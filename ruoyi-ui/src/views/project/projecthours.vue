<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;"
                @click="dialogvisbel = true; form = {}">新增</el-button>
            <div class="serachModel">
                <div class="topinput"> <span>搜索</span><el-input placeholder="请输入内容" suffix-icon="el-icon-search"
                        v-model="input1"></el-input>
                </div>
               
            </div>
            <el-button type="success" style="margin-left: 5px" @click="serach">搜索</el-button>
        </div>
        <!-- table -->
        <el-table :data="list" style="width: 100%">
            <el-table-column prop="name" label="姓名">
            </el-table-column>
            <el-table-column prop="phone" label="电话">
            </el-table-column>
            <el-table-column prop="position" label="职位">
            </el-table-column>
            <el-table-column prop="department" label="部门">
            </el-table-column>
            <el-table-column prop="basicSalary" label="基本工资">
            </el-table-column>
            <el-table-column prop="insuranceExpenses" label="保险费用">
            </el-table-column>

            <el-table-column prop="pkProjectArchives" label="操作" width="220px">
                <template slot-scope="scope" style="display: grid;grid-template-columns: repeat(3,1fr);">
                    <!-- <el-button @click="toDetail(scope.row)" size="mini">查看</el-button> -->
                    <el-button @click="edit(scope.row)" type="primary" size="mini">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40]" :page-size="10" layout="total,prev, pager, next, jumper" :total="total">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- newlayout -->
                <div class="mydialogInfo">
                    <div class="closedilog" @click="dialogvisbel = false;">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">{{ form.pkProjectArchives > 0 ? '修改档案' : '新增档案' }}</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">新增人员
                                <div class="close" @click="form = {}"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                        </div>

                        <div class="ddetail">
                            <!-- 第一列 -->
                            <el-row :gutter="10">
                                <el-col :span="12">
                                    <!-- -->

                                    <el-row :gutter="10">
                                        <el-col :span='12'>
                                            <div class="ddname">姓名</div>
                                            <el-form-item label-width="0" prop="projectName">
                                                <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
                                            </el-form-item>
                                        </el-col>
                                        <el-col :span='12'>
                                            <div>
                                                <div class="ddname">部门</div>
                                                <div>
                                                    <el-select v-model="form.department">
                                                        <el-option v-for="item in archiiveslist" :label="item.name"
                                                            :value="item.id" placeholder="请选择部门"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">角色</div>
                                                <div>
                                                    <el-select v-model="form.position" placeholder="请选择角色">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.name"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">电话</div>
                                                <div>
                                                    <el-input v-model.number="form.phone" placeholder="请输入电话"></el-input>
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
                                            <div class="ddname">基本工资</div>
                                            <div class="block">
                                                <el-input v-model.number="form.basicSalary" placeholder="请输入基本工资"></el-input>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">保险费用</div>
                                            <div class="block">
                                                <el-input v-model.number="form.insuranceExpenses" placeholder="请输入保险费用"></el-input>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">身份证号</div>
                                            <el-input v-model.number="form.idNum" placeholder="请输入身份证号"></el-input>
                                        </el-col>

                                        <!-- <el-col :span="12">
                                            <div class="ddname">项目金额</div>
                                            <el-input v-model.number="form.projectAmount"
                                                placeholder="请输入项目金额"></el-input>
                                        </el-col> -->
                                    </el-row>
                                </el-col>
                            </el-row>
                            <!-- 文本框 -->
                            <div class="pd10" v-if="false">
                                <div class="ddname">简介</div>
                                <div class="mark">请描述任务书简介</div>
                                <el-input v-model="form.target" type="textarea" :rows="5"></el-input>
                            </div>



                            <!-- 人员-->
                            <div class="pd10">
                                <div class="ddname">投入人员</div>
                                <div class="mark">所有人员信息</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                </div>
                                <el-table :data="pmsProjectArchivesPersonnelList" border style="width: 100%">
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
                                                <el-option label="管理员" value="1"></el-option>
                                                <el-option label="普通用户" value="2"></el-option>
                                                <el-option label="访客" value="3"></el-option>
                                            </el-select>
                                        </template>
                                    </el-table-column>

                                    <!--加入时间 -->
                                    <el-table-column prop="joinDate" label="加入时间">
                                        <template slot-scope="scope">
                                            <el-date-picker format="yyyy-MM-DD hh:mm:ss"
                                                value-format="yyyy-MM-DD hh:mm:ss" v-model="scope.row.joinDate"
                                                type="datetime" placeholder="选择加入时间">
                                            </el-date-picker>
                                        </template>
                                    </el-table-column>

                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="contactInformation" label="联系方式">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.contactInformation"
                                                placeholder="请输入联系方式"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>
                            </div>


                            <div class="savebtn">
                                <el-button style="color: white;background-color: #fb9337;"
                                    @click="saveinfo">保存</el-button>
                                <el-button @click="dialogvisbel = false; form = {}">取消</el-button>
                            </div>


                        </div>

                    </div>

                </div>

            </el-form>



        </el-dialog>



    </div>

</template>

<script>
import { listUser, getUser, addUser, updateUser, delUser }
 from '@/api/project/user.js'

export default {
    data() {
        return {
            currentPage: 1,
            total: null,
            typelist: [
                { id: 1, name: '研发项目' },
                { id: 2, name: '内部项目' },
            ],  //项目类型
            currentStep: 2,//当前步骤 
            showPopover: false,//编辑信息卡片
            queryParams: {},
            input1: '',
            personlist: [
                { name: '张三' },
                { name: '里斯' },
                { name: '王五' },
            ],  //人员列表
            deplist: [
                { name: '开发部' },
                { name: '测试部' },
                { name: '运营部' },
            ], //部门列表
            personSelect: '',
            personSelect2: '进行中',
            dateRange: '',
            dialogvisbel: false,
            tableData: [],
            form: {},
            lclist: [
                { id: 1, name: '模板1' },
                { id: 2, name: '模板A' },
                { id: 3, name: '模板C' },
            ],
            list3: [],
            selectedValue: null,
            fileList: [],
            list: [],//列表
            projectlist: [
                { name: '项目a' },
                { name: '项目b' },
                { name: '项目c' },
            ],//项目列表
            archiiveslist: [
                { id: 1, name: '档案1' },
                { id: 2, name: '档案2' },
                { id: 3, name: '档案3' },
            ],
            pmsProjectArchivesPersonnelList: [],//投入人员列表


        }
    },
    created() {
        this.getlist();
    },
    methods: {
        serach(){
            var _this=this;
            console.log('input',this.input1);
              var query={
                name:this.input1
              }
              listUser(query).then(res=>{
                console.log('aaa',res);
                _this.list=res.rows;
                
            })
            
        },
        // 每页显示个数
        handleSizeChange(newpage) {
            console.log('22', newpage);
            this.currentPage = newpage;
        },
        // 切换第几页
        handleCurrentChange(newPage) {
            console.log('1111', newPage);
            var _this = this;
            var query = {
                pageSize: 10,
                pageNum: newPage,
            }
            listProject_archives(query).then(res => {
                console.log('分页res', res);
                _this.list = res.rows;
            })

        },

        // 获取列表
        getlist() {
            var _this = this;
            listUser().then(res => {
                console.log(res);
                _this.list = res.rows;
                _this.total = res.total;
            })
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
        toDetail(row) {
            var id = row.pkProjectArchives
            this.$router.push('/project/brifDetail?id=' + id);
        },
        // 添加新行
        addRow() {
            this.pmsProjectArchivesPersonnelList.push({
                name: '',
                role: '',
                join_date: '',
                contact_information: ''
            })
            console.log('this.pmsProjectArchivesPersonnelList', this.pmsProjectArchivesPersonnelList);
        },
        // 表单提交
        saveinfo() {
            console.log('form', this.form);
            var data = this.form;
            data.pmsProjectArchivesPersonnelList = this.pmsProjectArchivesPersonnelList;
            var _this = this;

            if (data.pkProjectArchives > 0) {
                updateUser(data).then(res => {
                    if (res.code == '200') {
                        _this.dialogvisbel = false;
                        this.$message({
                            message: '修改成功',
                            type: 'success'
                        });
                        _this.form = {};
                        _this.getlist();
                    }
                })

            } else {
                
                addUser(data).then(res => {
                    console.log('res2', res);
                    if (res.code == '200') {
                        _this.dialogvisbel = false;
                        this.$message({
                            message: '添加成功',
                            type: 'success'
                        });
                        _this.form = {};
                        _this.getlist();
                    }
                })
            }


        },
        deleteRow(row) {
            var _this = this;
            var id = row.id;
            if (confirm('确定删除吗')) {
                delUser(id).then(res => {
                    if (res.code == '200') {
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                    }
                    _this.getlist();
                })
            }

        },
        // 编辑
        edit(row) {
            var _this = this;
            _this.dialogvisbel = true;
            var id = row.id;
            getUser(id).then(res => {
                console.log('edit', res);
                _this.form = res.data;
            })
            _this.getlist();
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
    grid-template-columns: auto 1fr auto;
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