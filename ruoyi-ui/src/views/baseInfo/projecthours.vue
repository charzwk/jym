<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;"
                @click="dialogvisbel = true; form = {}">新增</el-button>
            <div class="serachModel">
                <div class="topinput"> <span></span><el-input placeholder="请输入搜索内容" suffix-icon="el-icon-search"
                        v-model="input1"></el-input>
                </div>

            </div>
            <el-button type="success" style="margin-left: 5px" @click="serach">搜索</el-button>
        </div>
        <!-- table -->
        <el-table :data="list" style="width: 100%">
            <el-table-column prop="projectName" label="项目名称">
            </el-table-column>
            <el-table-column prop="customerArchives" label="客户档案">
            </el-table-column>
            <el-table-column prop="projectStartDate" label="项目开始时间">
            </el-table-column>
            <el-table-column prop="projectEndTime" label="项目截至时间">
            </el-table-column>
            <el-table-column prop="projectAmount" label="项目金额">
            </el-table-column>
            <el-table-column prop="projectLeader" label="负责人">
            </el-table-column>

            <el-table-column prop="pkProjectArchives" label="操作" width="220px">
                <template slot-scope="scope" style="display: grid;grid-template-columns: repeat(3,1fr);">
                    <el-button @click="toDetail(scope.row)" size="mini">查看</el-button>
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
                    <div class="closedilog" @click="dialogvisbel = false; pmsProjectArchivesPersonnelList = []">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">{{ form.id > 0 ? '修改工时' : '新增工时' }}</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">工时信息
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
                                            <div class="ddname">项目名称</div>
                                            <!--   -->
                                            <el-form-item label-width="0" prop="projectName">
                                                <el-select v-model="form.pkProjectArchives" placeholder="请选择要录入的项目">
                                                    <el-option v-for="item in projectlist" :label="item.projectName"
                                                        :value="item.pkProjectArchives"></el-option>
                                                </el-select>
                                            </el-form-item>
                                        </el-col>
                                        <el-col :span="12">
                                            <!-- <div class="ddname">项目类型</div>
                                            <el-select v-model="form.projectType" placeholder="请选择项目类型">
                                                <el-option v-for="item in typelist" :label="item.dictLabel"
                                                    :value="parseInt(item.dictValue)"></el-option>
                                            </el-select> -->
                                            <!-- <el-input v-model="prototype" :disabled="true"></el-input> -->
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">审批人</div>
                                                <div>
                                                    <el-select v-model="form.pkProjectPersonnel" placeholder="请选择审批人">
                                                        <el-option v-for="item in properson" :label="item.name"
                                                            :value="parseInt(item.pkProjectPersonnel)"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">审批人电话</div>
                                                <div>
                                                    <el-input v-model="phone" :disabled="true"></el-input>
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
                                                <el-date-picker format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                                                    v-model="form.startTime" type="datetime" placeholder="选择开始日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">结束日期时间</div>
                                            <div class="block">
                                                <el-date-picker format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                                                    v-model="form.endTime" type="datetime" placeholder="选择结束日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">所需工时</div>
                                            <el-input v-model="manhour" :disabled="true" placeholder="请选择日期（一天工时未为8小时）"></el-input>
                                        </el-col>

                                        <el-col :span="12">
                                            <div class="ddname">项目金额</div>
                                            <el-input v-model="proamout" :disabled="true"></el-input>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>






                            <div class="savebtn">
                                <el-button style="color: white;background-color: #fb9337;"
                                    @click="saveinfo">保存</el-button>
                                <el-button
                                    @click="dialogvisbel = false; form = {}; pmsProjectArchivesPersonnelList = []">取消</el-button>
                            </div>


                        </div>

                    </div>

                </div>

            </el-form>



        </el-dialog>



    </div>

</template>

<script>

import { listUser } from "@/api/project/user.js";
import { formatDate } from "@/utils/index.js";
import { listHour, getHour, addHour, updateHour, delHour } from "@/api/project/hour.js";
import {
    listProject_archives, pkProjectArchives, addProject_archives,
    updateProject_archives, delProject_archives, getProject_archives
} from '@/api/project/project_archives.js';

export default {
    name:'hours',
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
            personlist: [],  //人员列表
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
            form: {
                projectStartDate: '',
                projectEndTime: '',
                pmsProjectArchivesPersonnelList: []
            },
            lclist: [
            ],
            list3: [],
            selectedValue: null,
            fileList: [],
            list: [],//列表
            projectlist: [],//项目列表
            archiiveslist: [
            ],
            newPage: null,
            rolelist: [],//角色
            prolist: [],//项目列表
            // phone:null


        }
    },
    computed: {
        phone() {
            var id = this.form.pkProjectPersonnel;
            var index = this.personlist.findIndex(x => x.id == id);
            if (index !== -1) {
                return this.personlist[index].phone || '该审批人暂无电话信息'; // 使用默认值
            } else {
                return '请选择审批人';
            }


          
        },
        properson(){
            var id = this.form.pkProjectArchives;
            var index = this.projectlist.findIndex(x => x.pkProjectArchives == id);
            if (index !== -1) {
                return this.projectlist[index].pmsProjectArchivesPersonnelList || []; // 使用默认值
            } else {
                return '';
            }
        },
        proamout() {
            var id = this.form.pkProjectArchives;
            var index = this.projectlist.findIndex(x => x.pkProjectArchives == id);
            if (index !== -1) {
                return this.projectlist[index].projectAmount || ''; // 使用默认值
            } else {
                return '';
            }
        },
        manhour() {
            var form=this.form;
            const startDate = new Date(form.startTime);
            const endDate = new Date(form.endTime);
            if (isNaN(startDate) || isNaN(endDate)) {
                return '请选择日期(默认一天八个工时)'
            }
            // 计算毫秒差
            const timeDiff = endDate - startDate;
            if(timeDiff<0){
                this.$message({
                    message:'结束时间要大于开始时间',
                    type:'danger'
                })
                return '';
            }
            // 将毫秒差转换为天数
            const daysDiff = timeDiff / (1000 * 60 * 60 * 24);
           
           
            return daysDiff*8;

        }
    },
    created() {
        var _this = this;
        this.getlist();
        this.getperson();
        const dictType = "pls_role";
        this.getDicts(dictType).then(res => {
            _this.rolelist = res.data;

        })
        const dictType2 = "pls_protype";
        this.getDicts(dictType2).then(res => {
            console.log('ziduan', res);
            _this.typelist = res.data;

        })

        this.getProlist();


    },
    methods: {
        // 获取项目列表
        getProlist() {
            var _this = this;
            var query = {
                pageSize: 1000
            }
            listProject_archives(query).then(res => {
                _this.projectlist = res.rows;
                console.log('项目', res.rows);
            })
        },
        // 移除添加的人员
        delPerson(row) {
            console.log(row);
            var pkid = row.pkProjectPersonnel;
            var index = this.form.pmsProjectArchivesPersonnelList.findIndex(item => item.pkProjectPersonnel == pkid);
            this.form.pmsProjectArchivesPersonnelList = this.form.pmsProjectArchivesPersonnelList.splice(index, 1);
            this.$message({
                message: '删除成功',
                type: 'success'
            })

        },
        // 获取人员
        getperson() {
            var _this = this;
            listUser().then(res => {
                _this.personlist = res.rows;
                console.log('person', this.personlist);
            })
        },
        serach() {
            var _this = this;
            console.log('input', this.input1);
            var query = {
                projectName: this.input1
            }
            listProject_archives(query).then(res => {
                console.log('aaa', res);
                _this.list = res.rows;

            })

        },
        // 每页显示个数
        handleSizeChange(newpage) {
            console.log('22', newpage);
            this.currentPage = newpage;
        },
        // 切换第几页
        handleCurrentChange(newPage) {

            var _this = this;
            this.newPage = newPage;
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
            var query = {
                pageSize: 10,
                pageNum: this.newPage,
            }
            listHour(query).then(res => {
                console.log('getlist', res);
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
        },
        // 表单提交
        saveinfo() {
  
            var data = this.form;
            data.manHour=this.manhour;
            // data.pmsProjectArchivesPersonnelList = this.form.pmsProjectArchivesPersonnelList;
            var _this = this;
            if (data.id > 0) {
                updateHour(data).then(res => {
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
                addHour(data).then(res => {

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
                delHour(id).then(res => {
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
        async edit(row) {
            var _this = this;
            _this.dialogvisbel = true;
            var id = row.id;
            await getHour(id).then(res => {
                // res.data.startTime = formatDate(res.data.startTime);
                // res.data.endTime = formatDate(res.data.endTime);
                console.log('edithour',res.data);
                

                _this.form = res.data;
                // _this.manhour=res.data.manHour
                _this.form.pmsProjectArchivesPersonnelList = res.data.pmsProjectArchivesPersonnelList;
            })
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