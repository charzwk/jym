<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;"
                @click="dialogvisbel = true; form = {}; form.pmsProjectManHourList = []">新增</el-button>
            <div class="serachModel">
                <!-- suffix-icon="el-icon-search" -->
                <div class="topinput"> <span></span><el-input placeholder="请输入搜索内容" clearable
                        v-model="input1"></el-input>
                </div>

            </div>
            <el-button type="success" style="margin-left: 5px" @click="serach">搜索</el-button>
        </div>
        <!-- table -->
        <el-table :data="list" style="width: 100%">
            <el-table-column prop="projectName" label="项目名称">
            </el-table-column>
            <el-table-column prop="projectCode" label="项目编码">
            </el-table-column>
            <el-table-column prop="projectLeader" label="项目负责人">
            </el-table-column>
            <el-table-column prop="remark" label="备注">
                <template v-slot="scope">
                    {{ scope.row.remark==null ?'无' :'' }}
                </template>
            </el-table-column>
   

            <el-table-column prop="pkProjectArchives" label="操作">
                <template slot-scope="scope" style="display: grid;grid-template-columns: repeat(2,1fr);">
                    <el-button @click="Approval(scope.row)" size="mini" type="success">审批</el-button>
                    <el-button @click="toDetail(scope.row)" size="mini">查看</el-button>
                    <el-button @click="edit(scope.row)" type="primary" size="mini">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin-top: 10px;" @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40]" :page-size="10" layout="total,prev, pager, next, jumper" :total="total">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- newlayout -->
                <div class="mydialogInfo">
                    <div class="closedilog" @click="dialogvisbel = false; ">
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
                                            <div class="ddname">项目编码</div>
                                            <el-input v-model="projectInfo.projectCode" :disabled="true"></el-input>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">项目负责人</div>
                                                <div>
                                                    <el-input v-model="projectInfo.projectLeader"
                                                        :disabled="true"></el-input>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">项目金额</div>
                                            <el-input v-model="projectInfo.projectAmount" :disabled="true"></el-input>
                                        </el-col>
                                    </el-row>

                                </el-col>

                            </el-row>
                            <!-- 第二列 -->
                            <el-row :gutter="10" style="margin: 20px 0 ;" v-if="false">
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
                                        <!-- <el-col :span="12">
                                            <div class="ddname">所需工时</div>
                                            <el-input v-model="manhour" :disabled="true"
                                                placeholder="请选择日期（一天工时未为8小时）"></el-input>
                                        </el-col> -->

                                        <el-col :span="12">
                                            <div class="ddname">项目金额</div>
                                            <el-input v-model="projectInfo.projectAmount" :disabled="true"></el-input>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>

                            <!-- 标题 -->
                            <div class="dialoginfo" style="margin: 10px  0 ;">
                                <div class="dtitle">人员工时信息
                                    <div class="close"><img src="@/imgs/close.png" alt=""></div>
                                </div>
                            </div>


                            <!-- 设备-->
                            <div class="pd10">
                                <div class="ddname">投入人员</div>
                                <div class="mark">请给人员分配工时</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                    <el-button type="primary" @click="cacluteHour"
                                        style="background-color: green; ">计算工时</el-button>
                                </div>
                                <el-table :data="form.pmsProjectManHourList" border style="width: 100%">
                                    <!-- 序号列 -->
                                    <el-table-column type="index" label="序号" width="50">
                                    </el-table-column>

                                    <!-- 姓名列，使用 el-select 进行选择 -->
                                    <el-table-column prop="name" label="姓名">
                                        <template slot-scope="scope">
                                            <el-select v-model="scope.row.name" placeholder="请选择姓名" @change="getPK(scope.row, $event)">
                                                <el-option v-for="item in properson" :label="item.name" 
                                                    :value="item.name"></el-option>
                                            </el-select>
                                        </template>
                                    </el-table-column>

                            

                                    <!-- 角色列，使用 el-select 进行选择 -->
                                    <el-table-column prop="startTime" label="开始时间">
                                        <template slot-scope="scope">
                                            <el-date-picker format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                                                v-model="scope.row.startTime" type="datetime" placeholder="选择开始日期时间">
                                            </el-date-picker>
                                        </template>
                                    </el-table-column>

                                    <!--加入时间 -->
                                    <el-table-column prop="endTime" label="加入时间">
                                        <template slot-scope="scope">
                                            <el-date-picker format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                                                v-model="scope.row.endTime" type="datetime" placeholder="选择开始日期时间">
                                            </el-date-picker>
                                        </template>
                                    </el-table-column>

                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="manHour" label="工时">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.manHour" :disabled="true"
                                                placeholder="请输入联系方式"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger" @click="delPerson(scope.row)">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>


                            </div>






                            <div class="savebtn">
                                <el-button style="color: white;background-color: #fb9337;"
                                    @click="saveinfo">保存</el-button>
                                <el-button
                                    @click="dialogvisbel = false; form = {}; form.pmsProjectManHourList = []">取消</el-button>
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
    name: 'hours',
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
                pmsProjectManHourList: []
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
        // 项目下的人员
        properson() {
            var id = this.form.pkProjectArchives;
            var index = this.projectlist.findIndex(x => x.pkProjectArchives == id);
            if (index !== -1) {
                console.log('11',this.projectlist[index].pmsProjectArchivesPersonnelList);
                
                return this.projectlist[index].pmsProjectArchivesPersonnelList || []; // 使用默认值
            } else {
                return '';
            }
        },
        // 项目信息
        projectInfo() {
            var id = this.form.pkProjectArchives;
            var index = this.projectlist.findIndex(x => x.pkProjectArchives == id);
            if (index != -1) {
                return this.projectlist[index]
            } else {
                return {}
            }
        },

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
        getPK(row,value){
            // console.log(value);
            // var index=this.properson.findIndex(x=>x.name==value);
            // var id=this.properson[index].pkProjectPersonnel;

            const selectedItem = this.properson.find(item => item.name === value);
            if (selectedItem) {
                // 将选中的 id 赋值给对应行数据的 id 属性
                row.pkProjectPersonnel = selectedItem.pkProjectPersonnel;
            }
        
        },
        // 计算工时
        cacluteHour() {
            this.form.pmsProjectManHourList.forEach(item => {
                // 将 startTime 和 endTime 转换为 Date 对象
                let startDate = new Date(item.startTime);
                let endDate = new Date(item.endTime);

                // 计算两个日期之间的毫秒数差
                let timeDiff = endDate.getTime() - startDate.getTime();
                if (timeDiff < 0) {
                    this.$message({
                        message: '结束时间必须大于开始时间',
                        type: 'danger'
                    })
                }

                // 将毫秒数差转换为天数
                let dayDiff = timeDiff / (1000 * 3600 * 24);
                item.state=0;


                item.manHour = dayDiff * 8;
            });
        },
        // 审批
        Approval(row) {
            var id = row.pkProjectArchives;
        },
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
            listHour(query).then(res => {
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

        toDetail(row) {
            var id = row.id
            this.$router.push('/baseInfo/hourDetail?id=' + id);
        },
        // 添加新行
        addRow() {
            if (this.form.pmsProjectManHourList == undefined) {
                this.form.pmsProjectManHourList = []
            }
            this.form.pmsProjectManHourList.push({
                name: '',
                startTime: '',
                endTime: '',
                manHour: '',
                pkProjectPersonnel:'',
            })
        },
        // 表单提交
        saveinfo() {

            var data = this.form;
            data.projectName=this.projectInfo.projectName;
            data.projectCode=this.projectInfo.projectCode;
            data.projectLeader=this.projectInfo.projectLeader;
            console.log('data', data);
      
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
                console.log('edithour', res.data);
                _this.form = res.data;
                _this.form.pmsProjectArchivesPersonnelList = res.data.pmsProjectManHourList;
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