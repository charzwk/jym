<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;"
                @click="dialogvisbel = true; form = {}">新增</el-button>
            <div class="serachModel">
                <div class="topinput" >
                    <span>搜索：</span>
                    <el-input placeholder="请输入内容" v-model="input1">
                        <template #suffix>
                            <i class="el-icon-search" @click="handleSearch(suffix)"></i> <!-- 点击图标执行搜索 -->
                        </template>
                    </el-input>
                </div>
            </div>
        </div>
        <div>
    <!-- <el-upload
      ref="upload"
      class="upload-demo"
      :before-upload="beforeUpload"
      :auto-upload="false"
      :on-change="handleChange"
      :http-request="uploadFile"
    >
      <el-button type="primary">选择 Excel 文件</el-button>
    </el-upload>
    <el-button type="success" @click="submitUpload" :disabled="!file">上传文件</el-button> -->
  </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="项目名称">
            </el-table-column>
            <el-table-column prop="target" label="项目目标">
            </el-table-column>
            <el-table-column prop="decompose" label="研究内容分解">
            </el-table-column>
            <el-table-column prop="demand" label="设备需求">
            </el-table-column>

            <el-table-column prop="id" label="操作" width="220">
                <template slot-scope="scope" style="display: grid;grid-template-columns: 1fr 1fr 1fr;">

                    <el-button @click="toDetail" size="mini">查看</el-button>
                    <el-button @click="edit(scope.row)" type="primary" size="mini">编辑</el-button>
                    <el-button @click="deleteRow2(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog :visible.sync="dialogvisbel" width="70%">

            <el-form ref="form" :model="form" label-width="100px" style="margin: 0 15px;padding: 0;">
                <!-- 第一步 项目信息 -->
                <div v-if="false">
                    <div>
                        <el-form-item label="项目名称">
                            <el-input v-model="form.info11" type="text" :rows="4" placeholder="请输入项目名称"></el-input>
                        </el-form-item>
                        <el-form-item label="专项">
                            <el-select v-model="zxinfo" placeholder="请选择是否专项">
                                <el-option v-for="item in isZx" :label="item.zx" :value="item.zx"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="项目目标">
                            <el-input v-model="form.info1" type="textarea" :rows="4" placeholder="请输入项目目标"></el-input>
                        </el-form-item>

                        <el-form-item label="研究内容分解">
                            <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input>
                        </el-form-item>

                        <el-form-item label="设备需求">
                            <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入设备需求"></el-input>
                        </el-form-item>

                        <el-form-item label="人员配置">
                            <el-button type="primary">新增人员</el-button>
                            <el-table :data="tableData" style="width: 100%">
                                <el-table-column prop="name" label="姓名">
                                </el-table-column>
                                <el-table-column prop="target" label="角色">
                                </el-table-column>
                                <el-table-column prop="target" label="备注">
                                </el-table-column>
                                <el-table-column prop="name" label="操作">
                                    <template slot-scope="scope">
                                        <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                                        <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                                    </template>
                                </el-table-column>

                            </el-table>
                        </el-form-item>

                        <el-form-item label="设备清单">
                            <el-button type="primary">新增设备</el-button>
                            <el-table :data="tableData" style="width: 100%">
                                <el-table-column prop="name" label="设备名称">
                                </el-table-column>
                                <el-table-column prop="target" label="花费">
                                </el-table-column>
                                <el-table-column prop="target" label="备注">
                                </el-table-column>
                                <el-table-column prop="name" label="操作">
                                    <template slot-scope="scope">
                                        <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                                        <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                                    </template>
                                </el-table-column>

                            </el-table>
                        </el-form-item>

                        <el-form-item label="投入费用计划">
                            <el-button type="primary">新增</el-button>
                            <el-table :data="tableData" style="width: 100%">
                                <el-table-column prop="name" label="费用姓项">
                                </el-table-column>
                                <el-table-column prop="target" label="费用金额">
                                </el-table-column>
                                <el-table-column prop="target" label="备注">
                                </el-table-column>
                                <el-table-column prop="name" label="操作" width="220">
                                    <template slot-scope="scope"
                                        style="display: grid;grid-template-columns: repeat(3,1fr);">
                                        <el-button @click="toDetail" size="mini">查看</el-button>
                                        <el-button @click="dialogvisbel = true" type="primary"
                                            size="mini">编辑</el-button>
                                        <el-button @click="deleteRow(scope.row)" type="danger"
                                            size="mini">删除</el-button>
                                    </template>
                                </el-table-column>

                            </el-table>
                        </el-form-item>
                    </div>
                    <el-form-item>
                        <div class="form-buttons">
                            <el-button type="primary" @click="onSubmit">保存</el-button>
                            <el-button @click="dialogvisbel = false">取消</el-button>
                        </div>
                    </el-form-item>
                </div>

                <!-- newlayout -->
                <div class="mydialogInfo">
                    <div class="closedilog" @click="dialogvisbel = false;">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">项目申报</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">项目基础情况
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                        </div>

                        <div class="ddetail">
                            <!-- 第一列 -->
                            <el-row :gutter="10">
                                <el-col :span="12">
                                    <div>
                                        <div class="ddname">项目名称</div>
                                        <div><el-input v-model="form.name" placeholder="请输入项目名称"></el-input></div>
                                    </div>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">项目负责人</div>
                                                <div>
                                                    <el-select v-model="form.person" placeholder="请选择负责人">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">所属部门</div>
                                                <div>
                                                    <el-select v-model="form.dep" placeholder="请选择部门">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                    </el-row>

                                </el-col>

                            </el-row>
                            <!-- 第二列 -->
                            <el-row :gutter="10" style="margin: 20px 0 ;">
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">选择开始日期时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem1" type="datetime"
                                                    placeholder="选择开始日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">选择开始日期时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem2" type="datetime"
                                                    placeholder="选择开始日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">项目类型</div>
                                            <el-select v-model="form.typename" placeholder="请选择项目类型">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>

                                        <el-col :span="12">
                                            <div class="ddname">专项</div>
                                            <el-select v-model="form.iszx" placeholder="请选择项目类型">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>

                            <div class="pd10">
                                <div class="ddname">项目目的</div>
                                <div class="mark">分析项目的背景和目的</div>
                                <el-input v-model="form.target" type="textarea" :rows="5"></el-input>
                            </div>

                            <div class="pd10">
                                <div class="ddname">研究内容分解</div>
                                <div class="mark">分析项目的背景和目的</div>
                                <el-input v-model="form.decompose" type="textarea" :rows="5"></el-input>
                            </div>

                            <div class="pd10">
                                <div class="ddname">设备需求</div>
                                <div class="mark">分析项目的背景和目的</div>
                                <el-input v-model="form.demand" type="textarea" :rows="5"></el-input>
                            </div>

                            <!-- 人员-->
                            <div class="pd10">
                                <div class="ddname">人员配置</div>
                                <div class="mark">所有人员信息</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                </div>
                                <el-table :data="list3" border style="width: 100%">
                                    <!-- 序号列 -->
                                    <el-table-column type="index" label="序号" width="50">
                                    </el-table-column>

                                    <!-- 姓名列，使用 el-select 进行选择 -->
                                    <el-table-column prop="name" label="姓名">
                                        <template slot-scope="scope">
                                            <el-select v-model="scope.row.name" placeholder="请选择姓名">
                                                <el-option label="张三" value="张三"></el-option>
                                                <el-option label="李四" value="李四"></el-option>
                                                <el-option label="王五" value="王五"></el-option>
                                            </el-select>
                                        </template>
                                    </el-table-column>

                                    <!-- 角色列，使用 el-select 进行选择 -->
                                    <el-table-column prop="role" label="角色">
                                        <template slot-scope="scope">
                                            <el-select v-model="scope.row.role" placeholder="请选择角色">
                                                <el-option label="管理员" value="管理员"></el-option>
                                                <el-option label="普通用户" value="普通用户"></el-option>
                                                <el-option label="访客" value="访客"></el-option>
                                            </el-select>
                                        </template>
                                    </el-table-column>

                                    <!-- 部门列，使用 el-input 进行输入 -->
                                    <el-table-column prop="department" label="部门">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.department" placeholder="请输入部门"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="remark" label="备注">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.remark" placeholder="请输入备注"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger" @click="deleteRow(scope.$index)">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>
                            </div>
                            <!-- 设备 -->
                            <div class="pd10">
                                <div class="ddname">设备清单</div>
                                <div class="mark">所需设备信息</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                </div>
                                <el-table :data="list3" border style="width: 100%">
                                    <!-- 序号列 -->
                                    <el-table-column type="index" label="序号" width="50">
                                    </el-table-column>

                                    <!-- 姓名列，使用 el-select 进行选择 -->
                                    <el-table-column prop="name" label="设备名称">
                                        <template slot-scope="scope">
                                            <el-select v-model="scope.row.name" placeholder="请选择设备名称">
                                                <el-option label="张三" value="张三"></el-option>
                                                <el-option label="李四" value="李四"></el-option>
                                                <el-option label="王五" value="王五"></el-option>
                                            </el-select>
                                        </template>
                                    </el-table-column>

                                    <!-- 角色列，使用 el-select 进行选择 -->
                                    <el-table-column prop="role" label="设备费用">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.role" placeholder="请输入设备费用"></el-input>
                                        </template>
                                    </el-table-column>
                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="remark" label="备注">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.remark" placeholder="请输入备注"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger" @click="deleteRow(scope.$index)">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>
                            </div>

                            <!-- 投入费用 -->
                            <div class="pd10">
                                <div class="ddname">投入费用计划</div>
                                <div class="mark">计划使用的投入费用和明细</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                </div>
                                <el-table :data="list3" border style="width: 100%">
                                    <!-- 序号列 -->
                                    <el-table-column type="index" label="序号" width="50">
                                    </el-table-column>

                                    <!-- 姓名列，使用 el-select 进行选择 -->
                                    <el-table-column prop="name" label="费用事项">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.name" placeholder="请输入费用事项"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 角色列，使用 el-select 进行选择 -->
                                    <el-table-column prop="role" label="金额">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.role" placeholder="请输入金额"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="remark" label="备注">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.remark" placeholder="请输入备注"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger" @click="deleteRow(scope.$index)">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>
                            </div>


                            <div class="savebtn">
                                <el-button style="color: white;background-color: #fb9337;"
                                    @click="saveinfo">保存</el-button>
                                <el-button @click="dialogvisbel = false">取消</el-button>
                            </div>


                        </div>

                    </div>

                </div>




            </el-form>



        </el-dialog>



    </div>

</template>

<script>
export default {
    data() {
        return {
            currentStep: 2,//当前步骤 
            showPopover: false,//编辑信息卡片
            zxinfo: '',
            typelist: [
                {
                    "id": 1,
                    "name": "软件开发"
                },
                {
                    "id": 2,
                    "name": "市场营销"
                },
                {
                    "id": 3,
                    "name": "产品设计"
                }
            ],
            isZx: [
                { id: 1, zx: '是' },
                { id: 1, zx: '否' },
            ],
            queryParams: {},
            input1: '',
            personlist: [
                { id: 1, name: '张三' },
                { id: 2, name: '里斯' },
                { id: 3, name: '王五' },
            ],
            list3: [
                { id: 1, name: '水费', role: '5000', remark: '暂无备注' }
            ],
            personSelect: '',
            personSelect2: '进行中',
            dateRange: '',
            dialogvisbel: false,
            tableData: [
                { id: 1, name: '基哥项目调研报告', target: 'xxxxx', decompose: '1,xxxxxx,2xxxx,3xxx', demand: '内存必须大于32' }
            ],
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            lclist: [
                { id: 1, name: '模板1' },
                { id: 2, name: '模板A' },
                { id: 3, name: '模板C' },
            ],
            file: null, // 存储当前选择的文件
            selectedValue: null,
            fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' },
            { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }]

        }
    },
    methods: {
   // 在上传前进行文件格式校验
   beforeUpload(file) {
      const isExcel = file.type === 'application/vnd.ms-excel' ||
                      file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      if (!isExcel) {
        this.$message.error('只允许上传Excel文件！');
      }
      return isExcel;
    },
    // 当文件选择变化时触发
    handleChange(file) {
      this.file = file.raw; // 更新文件
    },
    // 手动触发上传
    submitUpload() {
      if (!this.file) {
        this.$message.error('请先选择文件！');
        return;
      }
      this.$refs.upload.submit();
    },
    // 自定义上传方法
    uploadFile({ file }) {
      const formData = new FormData();
      formData.append('file', file);

      return fetch('http://192.168.3.155:8080/api/excel/upload', {
        method: 'POST',
        body: formData
      })
        .then(response => {
          if (!response.ok) {
            throw new Error('文件上传失败！');
          }
          return response.json();
        })
        .then(result => {
          console.log("文件上传成功：", result);
          this.$message.success('文件上传成功！');
        })
        .catch(error => {
          console.error("上传出错：", error);
          this.$message.error('文件上传失败！');
        });
    },
        saveinfo() {
            console.log('form', this.form);
            var id = 2;
            this.form.id = id;
            this.tableData.unshift(this.form);
            id++;
            this.dialogvisbel = false;

        },
        handleSearch(row) {
            console.log(row);

        },
        onSubmit() { },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file);
        },
        handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${file.name}？`);
        },
        toDetail(url) {
            window.open(url, '_blank')
        },
        toDetail() {
            this.$router.push('/project/projectDetail')
        },
        addRow() {
            this.list3.push({
                name: '',
                role: '',
                department: '',
                remark: '',
            });
        },

        // 删除选中的行
        deleteRow(index) {
            index = index - 1;
            this.list3.splice(index, 1);
        },
        deleteRow2(index) {
            index = index - 1;
            if (confirm('确定删除吗')) {
                this.tableData.splice(index, 1);
            }

        },
        edit(row) {
            console.log(row.id);
            var index = this.tableData.findIndex(item => item.id == row.id);
            this.form = this.tableData[index];
            this.dialogvisbel = true;
        }
    }
}
</script>

<style scoped lang="scss">
.contain {
    padding: 10px 30px;
}

.header {

    display: grid;
    grid-template-columns: auto 1fr;
    margin-bottom: 10px;
    margin-top: 10px;

    .serachModel {
        justify-self: end;
    }

}

.file {
    display: grid;
    grid-template-columns: 1fr 1fr;
}
</style>