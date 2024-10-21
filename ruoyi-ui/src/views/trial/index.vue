<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button>
            <!-- <el-button style="color: white;background-color: #2468f2;" @click="excelimport">测试excel导入</el-button> -->


            <div class="serachModel">
                <div> <el-input placeholder="请输入内容" suffix-icon="el-icon-search" v-model="input1">
                    </el-input></div>
            </div>
        </div>
        
        <div>
      
  </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="试验名称">
            </el-table-column>
            <el-table-column prop="picker" label="领料人">
            </el-table-column>
            <el-table-column prop="pickerphone" label="领料人电话">
            </el-table-column>
            <el-table-column prop="approver" label="审批人">
            </el-table-column>
          
            <el-table-column prop="Approverphone" label="审批人电话">
            </el-table-column>
            <el-table-column prop="time" label="创建日期">
            </el-table-column>
            <el-table-column prop="name" label="操作" width="220">
                <template slot-scope="scope" style="display: grid;grid-template-columns: 1fr 1fr 1fr;">

                    <el-button @click="toDetail" size="mini">查看</el-button>
                    <el-button @click="dialogvisbel = true" type="primary" size="mini">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div v-if="false">
                 
                    <el-form-item label="试验名称">
                        <el-input v-model="form.info11" type="text" :rows="4" placeholder="请输入试验名称"></el-input>
                    </el-form-item>
                    <el-form-item label="任务书">
                        <el-select v-model="form.info3" placeholder="请选择任务书">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                       
                    </el-form-item>
                    <el-form-item label="任务阶段">
                        <el-select v-model="form.info3" placeholder="请选择阶段">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                      
                    </el-form-item>

                    <el-form-item label="领料人">
                        <el-select v-model="form.info3" placeholder="请选择领料人">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="领料人电话">
                        <el-input v-model.number="form.info1" type="text"  placeholder="请输入领料人电话"></el-input>
                    </el-form-item>

                    <el-form-item label="审批人">
                        <el-select v-model="form.info3" placeholder="请选择审批人">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="审批人电话">
                        <el-input v-model.number="form.info1" type="text"  placeholder="请输入审批人电话"></el-input>
                    </el-form-item>

                  

                    <el-form-item label="创建时间">
                        <el-date-picker v-model="dateRange" type="datetime"  placeholder="请选择时间"
                             style="width: 400px;">
                        </el-date-picker>
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
                            <div style="padding: 10px;">试验领料</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">领料信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                        </div>

                        <div class="ddetail">
                            <!-- 第一列 -->
                            <el-row :gutter="10">
                                <el-col :span="12">
                                    <!-- -->

                                    <el-row :gutter="10">
                                        <el-col :span='12'>
                                            <div>
                                                <div class="ddname">关联项目</div>
                                                <div>
                                                    <el-select v-model="form.person" placeholder="请选择项目">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span='12'>
                                            <div>
                                                <div class="ddname">试验名称</div>
                                                <div><el-input v-model="form.name" placeholder="请输入试验名称"></el-input>
                                                </div>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">领料人</div>
                                                <div>
                                                    <el-select v-model="form.person" placeholder="请选择领料人">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">领料人电话</div>
                                                <div>
                                                   <el-input v-model="recericePhone" placeholder="请输入领料人电话"></el-input>
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
                                            <div class="ddname">审批人</div>
                                            <div class="block">
                                                <el-select v-model="form.person" placeholder="请选择审批人">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">审批人电话</div>
                                            <div class="block">
                                                <div>
                                                   <el-input v-model="recericePhone" placeholder="请输入审批人电话"></el-input>
                                                </div>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">任务阶段</div>
                                            <el-select v-model="form.typename" placeholder="请选择任务阶段">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>

                                        <el-col :span="12">
                                            <div class="ddname">专项</div>
                                            <el-select v-model="form.iszx" placeholder="是否专项">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>

                            <div class="pd10">
                                <div class="ddname">试验步骤</div>
                                <div class="mark">请简述方案步骤</div>
                                <el-input v-model="form.target" type="textarea" :rows="5"></el-input>
                            </div>

                            <div class="pd10">
                                <div class="ddname">预期结果</div>
                                <div class="mark">请描述预期结果</div>
                                <el-input v-model="form.decompose" type="textarea" :rows="5"></el-input>
                            </div>


                        

                            <!-- 材料信息 -->
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
            queryParams: {},
            phaseslist:[
                {id:1,name:'验证阶段'},
                {id:2,name:'小试阶段'},
                {id:3,name:'中试阶段'},
                {id:4,name:'产业化'},
            ],
            input1: '',
            personlist: [
                { id: 1, name: '张三' },
                { id: 2, name: '里斯' },
                { id: 3, name: '王五' },
            ],
            personSelect: '',
            personSelect2: '进行中',
            dateRange: '',
            dialogvisbel: false,
            tableData: [
                { name: '试验测试1', picker:'张三',approver:'里斯',pickerphone: '135xxxxxxx', Approverphone: '156xxxxxxx',time:'2020-10-10 12:00' },

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
            selectedValue: null,
            fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' },
             { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }]

        }
    },
    methods: {
        beforeUpload(file) {
      const isExcel = file.type === 'application/vnd.ms-excel' ||
                      file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      if (!isExcel) {
        this.$message.error('只允许上传Excel文件！');
      }
      return isExcel; // 返回false则停止上传
    },
        // 当文件选择变化时触发
    handleChange(file, fileList) {
      console.log("文件发生变化：", file, fileList);
      this.fileList = fileList; // 更新文件列表
    },

     // 上传文件的函数
     async uploadFiles() {
      if (this.fileList.length === 0) {
        this.$message.error('请先选择文件！');
        return;
      }

      // 取出要上传的文件
      const file = this.fileList[0].raw; // Element Upload 的 raw 属性

      // 创建 FormData 对象
      const formData = new FormData();
      formData.append('file', file); // 添加文件到 FormData

      try {
        const response = await fetch('http://192.168.3.155:8080/api/excel/upload', {
          method: 'POST',
          body: formData
        });
        
        if (!response.ok) {
          throw new Error('文件上传失败！');
        }

        const result = await response.json();
        console.log("文件上传成功：", result);
        
        // 假设后端返回的响应中有文件的 URL
        const fileUrl = result.data.fileUrl; // 根据实际情况更改
        this.uploadedFiles.push({
          name: file.name,
          size: file.size,
          url: fileUrl
        });
        this.$message.success('文件上传成功！');
      } catch (error) {
        console.error("上传出错：", error);
        this.$message.error(error.message || '上传出现错误！');
      }
    },

      // 当文件状态变化时触发
      handleChange(file, fileList) {
      console.log("文件发生变化：", file, fileList);
      this.fileList = fileList; // 更新文件列表
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
        toDetail(url){
            window.open(url,'_blank')
        },
        toDetail(){
            this.$router.push('/trial/trialDetail')
        },
        excelimport(){
            var  url='http://192.168.3.155:8080/api/excel/upload';
            var file='';
            fetch();
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
.file{
    display: grid;
    grid-template-columns: 1fr 1fr;
}
</style>