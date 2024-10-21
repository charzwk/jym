<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button>
            <div class="serachModel">
                <div> <el-input placeholder="请输入内容" suffix-icon="el-icon-search" v-model="input1">
                    </el-input></div>
            </div>
        </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="项目名称">
            </el-table-column>
            <el-table-column prop="code" label="任务编号">
            </el-table-column>
            <el-table-column prop="phone" label="负责人电话">
            </el-table-column>
            <el-table-column prop="joinphone" label="参与人电话">
            </el-table-column>
            <el-table-column prop="precost" label="经费预算">
            </el-table-column>
            <el-table-column prop="target" label="目标">
            </el-table-column>
          
            <el-table-column prop="name" label="操作" width="220px">
                <template slot-scope="scope" style="display: grid;grid-template-columns: repeat(3,1fr);">
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
        <el-dialog  :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div v-if="false">
                 
                    <el-form-item label="报告标题">
                        <el-input v-model="form.info11" type="text" :rows="4" placeholder="请输入报告标题"></el-input>
                    </el-form-item>

                    <el-form-item label="简介">
                        <el-input v-model="form.info1" type="textarea" :rows="4" placeholder="请输入简介"></el-input>
                    </el-form-item>

                    <el-form-item label="结论">
                        <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input>
                    </el-form-item>

                    <el-form-item label="建议">
                        <el-input v-model="form.info3" type="textarea" :rows="4" placeholder="请输入市场需求分析"></el-input>
                    </el-form-item>

                    <el-form-item label="创建时间">
                        <el-date-picker v-model="dateRange" type="date"  placeholder="请选择时间"
                             style="width: 400px;">
                        </el-date-picker>
                    </el-form-item>

                    <el-form-item label="创建人">
                        <el-input v-model="form.info5" type="textarea" :rows="4" placeholder="请输入调研结论"></el-input>
                    </el-form-item>

                    <el-form-item label="状态">
                        <el-select v-model="personSelect2">
                            <el-option v-for="item in personlist" :label="item.name" :value="item.id">进行中</el-option>
                        </el-select>
                    </el-form-item>

                    <!-- <el-form-item label="附件上传">
                        <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"
                            :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple
                            :limit="3" :on-exceed="handleExceed" :file-list="[]">
                            <div class="filelist">
                                <div class="file" v-for="item in fileList">
                                    <div style="color: #2468f2;">{{ item.name }}</div>
                                    <div style="color: #2468f2;justify-self: end;" @click="toDetail(item.url)">编辑</div>
                                </div>
                            </div>
                            <el-button size="small" type="primary">点击上传</el-button>
                            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                        </el-upload>
                    </el-form-item>
                    <el-form-item label="请选择上传人">
                        <el-select v-model="personSelect">
                            <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                }}</el-option>
                        </el-select>
                    </el-form-item> -->

                </div>

                      <!-- newlayout -->
                      <div class="mydialogInfo" v-else>
                    <div class="closedilog" @click="dialogvisbel = false;">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">新增任务书</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">任务书信息
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
                                        <div><el-input v-model="form.name" placeholder="请选择项目"></el-input></div>
                                    </div>
                                        </el-col>
                                        <el-col :span='12'>
                                            <div>
                                        <div class="ddname">任务书标题</div>
                                        <div><el-input v-model="form.name" placeholder="请输入任务书标题"></el-input></div>
                                    </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">负责人</div>
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
                                            <div class="ddname">开始日期时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem1" type="datetime"
                                                    placeholder="选择开始日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">结束日期时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem2" type="datetime"
                                                    placeholder="选择结束日期时间">
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
                                <div class="ddname">简介</div>
                                <div class="mark">请描述任务书简介</div>
                                <el-input v-model="form.target" type="textarea" :rows="5"></el-input>
                            </div>

                            <div class="pd10">
                                <div class="ddname">结论</div>
                                <div class="mark">请描述任务书简介</div>
                                <el-input v-model="form.decompose" type="textarea" :rows="5"></el-input>
                            </div>

                            <div class="pd10">
                                <div class="ddname">建议</div>
                                <div class="mark">请描述任务书简介</div>
                                <el-input v-model="form.demand" type="textarea" :rows="5"></el-input>
                            </div>

                            <!-- 人员-->
                            <div class="pd10">
                                <div class="ddname">投入人员</div>
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
            queryParams: {},
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
                { name: '预期市场行情', code: '02902982', phone: '1092xxxxx', joinphone: '172xxxxx', precost: '20002', target: 'xxxx'}
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
            this.$router.push('/project/brifDetail')
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