<template>
    <div class="header">
        <div>
            <h3>筛选</h3>
        </div>
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">

            <el-row :span="24">
                <el-col :span="6">
                    <el-form-item label="项目查询" prop="tableName">
                        <el-input v-model="queryParams.tableName" placeholder="请输入表名称" clearable
                            @keyup.enter.native="handleQuery" />
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="项目阶段" prop="tableComment">
                        <el-input v-model="queryParams.tableComment" placeholder="请输入表描述" clearable
                            @keyup.enter.native="handleQuery" />
                    </el-form-item></el-col>
                <el-col :span="6">
                    <el-form-item label="归属单位">
                        <el-date-picker v-model="dateRange" style="width: 240px" value-format="yyyy-MM-dd"
                            type="daterange" range-separator="-" start-placeholder="开始日期"
                            end-placeholder="结束日期"></el-date-picker>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="创建时间">
                        <el-date-picker v-model="dateRange" style="width: 240px" value-format="yyyy-MM-dd"
                            type="daterange" range-separator="-" start-placeholder="开始日期"
                            end-placeholder="结束日期"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row :span="24">
                <el-col :span="6">

                    <el-form-item label="项目类型">
                        <el-input v-model="queryParams.tableName" placeholder="请输入项目类型" clearable
                            @keyup.enter.native="handleQuery" />
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="负责单位">
                        <el-input v-model="queryParams.tableName" placeholder="请输入负责单位" clearable
                            @keyup.enter.native="handleQuery" />
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="审核状态">
                        <el-input v-model="queryParams.tableName" placeholder="请输入审核状态" clearable
                            @keyup.enter.native="handleQuery" />
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-button type="success" @click="addProject">+新增项目</el-button>
                </el-col>


            </el-row>


            <el-form-item style="display: none;">
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <div>
            <h3>列表</h3>
        </div>
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="date" label="项目编码" width="180">
            </el-table-column>
            <el-table-column prop="name" label="项目名称" width="180">
            </el-table-column>
            <el-table-column prop="address" label="项目类型">
            </el-table-column>
            <el-table-column prop="date" label="负责单位" width="180">
            </el-table-column>
            <el-table-column prop="name" label="项目归属" width="180">
            </el-table-column>
            <el-table-column width="120" prop="address" label="项目负责人">
            </el-table-column>
            <el-table-column prop="date" label="项目金额" width="180">
            </el-table-column>
            <el-table-column prop="name" label="项目阶段" width="180">
            </el-table-column>
            <el-table-column prop="address" label="创建日期">
            </el-table-column>
            <el-table-column prop="date" label="创建人" width="180">
            </el-table-column>
            <el-table-column prop="name" label="审核状态" width="180">
            </el-table-column>
            <el-table-column prop="oprate" label="操作">
            </el-table-column>
        </el-table>

        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog title="新增项目" :visible.sync="dialogvisbel" width="50%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div v-if="currentStep == 1">
                    <el-row :gutter="20">
                        <el-col :span="12">
                            <el-form-item label="项目名称">
                                <el-input v-model="form.name" placeholder="请输入项目名称"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="项目编码">
                                <el-input v-model="form.name" placeholder="请输入项目编码"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="20">
                        <el-col :span="12">
                            <el-form-item label="项目背景">
                                <el-input v-model="form.name" placeholder="请输入项目背景"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="项目分管机构">
                                <el-input v-model="form.name" placeholder="请输入项目分管机构"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="20">
                        <el-col :span="16">
                            <el-form-item label="流程模板" style="color: red;">

                                <el-select v-model="selectedValue">
                                    <el-option v-for="item in lclist" :label="item.name" :value="item.id">{{ item.name
                                        }}</el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="20">
                        <el-col :span="12">
                            <el-form-item label="项目金额">
                                <el-input v-model="form.name" placeholder="请输入项目金额"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="项目研究内容">
                                <el-input v-model="form.name" placeholder="请输入项目研究内容"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="项目说明">
                                <el-input type="textarea" :rows="4" style="width: 500px;"
                                    placeholder="请输入项目说明"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>
                <!-- 项目人员 -->
                <div v-if="currentStep == 2">
                    <div>
                        <h3>搜索人员</h3>
                    </div>
                    <el-input v-model="form.name" placeholder="请输入工号或则姓名"></el-input>
                    <div>
                        <h3>项目成员</h3>
                    </div>
                    <div class="personModel">
                        <div class="personitem">
                            <div class="personname">刘某某</div>
                            <div class="personname" style="justify-self: end;">负责人</div>
                        </div>
                        <div class="personitem">
                            <div class="personname">占山</div>

                            <div style="justify-self: end;">
                                 <!-- 弹出框，包含卡片内容 -->
                            <el-popover :visible="showPopover" placement="right" width="200" trigger="click"
                                content="这是卡片内容，可以包含更多信息。">
    
                                <!-- 卡片内容 -->
                                <div class="card">
                                    <!-- <div class="card-header">卡片标题</div> -->
                                    <div class="card-body">
                                        <div>
                                            <p>负责人</p>
                                            <p>可编辑活操作，可调整协作人员威负责人</p>
                                        </div>
                                        <div>
                                            <p style="color:#3f82b3">可编辑</p>
                                            <p>可编辑活操作，可调整协作人员编辑权限</p>
                                        </div>
                                        <div>
                                            <p>可查看</p>
                                            <p>尽可查看数据，不可进行编辑或操作</p>
                                        </div>
                                        <div>
                                            <h2 style="color: red;">移除</h2>
                                           
                                        </div>
                                    </div>
                                </div>
                                <div class="personname personedit" slot="reference" @click="personedit">编辑</div>
                            </el-popover>
                            </div>
                         

                           
                        </div>
                        <div class="personitem">
                            <div class="personname">里斯</div>
                            <div class="personname personedit">编辑</div>
                        </div>
                    </div>

                </div>







                <el-divider></el-divider>
                <!-- 步骤模块 -->
                <div class="stpinfo">
                    <div class="step">
                        <div class="stepitem">
                            <div class="stepnum " :class="currentStep == 1 ? 'stepnumActive' : ''">1</div>基本信息 <span> <img
                                    src="@/imgs/arrRight.png" alt=""></span>
                        </div>
                        <div class="stepitem">
                            <div class="stepnum" :class="currentStep == 2 ? 'stepnumActive' : ''">2</div>项目成员信息 <span> <img
                                    src="@/imgs/arrRight.png" alt=""></span>
                        </div>
                        <div class="stepitem">
                            <div class="stepnum" :class="currentStep == 3 ? 'stepnumActive' : ''">3</div>其他信息
                        </div>
                    </div>

                    <div class="next" @click="tonext" v-if="currentStep == 1">下一步</div>
                    <div style="display: grid;grid-template-columns: 1fr 1fr;" v-else>
                        <div class="next" @click="topre">上一步</div>
                        <div class="next" @click="tonext">下一步</div>
                    </div>


                </div>



                <el-form-item style="display: none;">
                    <el-button type="primary" @click="onSubmit">立即创建</el-button>
                    <el-button>取消</el-button>
                </el-form-item>
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
            dateRange: '',
            dialogvisbel: true,
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄',
                oprate: '操作'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄',
                oprate: '操作'
            }
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

        }
    },
    methods: {
        personedit(){
            this.showPopover=true;
            console.log('showPopover',this.showPopover);
            
        },
        handleQuery() {

        },
        handleQuery() { },
        resetQuery() { },
        onSubmit() {
            console.log('submit!');
        },
        // 新增项目
        addProject() {
            this.dialogvisbel = true;
        },
        // 下一步
        tonext() {
            this.currentStep++;
        },
        topre() {
            this.currentStep--;
        }
    }

}
</script>
<style scoped lang="scss">
.header {
    /* border: 1px solid; */
    margin: 0px 30px 30px 10px;
    padding: 10px;
}

.personModel {
    .personitem {
        display: grid;
        grid-template-columns: 1fr 1fr;

        .personname {}

        .personedit {
            color: blue;
            justify-self: end;
        }
    }
}

.stpinfo {
    display: grid;
    grid-template-columns: 4fr 1fr;
    padding: 10px 0;

    .step {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        align-items: center;

        .stepitem {
            position: relative;
            text-align: center;
            font-size: 20px;
            color: #000;
        }

        span {
            position: absolute;
            right: 0px;
            top: 50%;
            width: 20px;
            height: 20px;
            transform: translateY(-60%);


        }

        span img {
            width: 20px;
            height: 20px;
        }

        .stepnum {
            border: 1px solid #eee;
            display: inline-block;
            padding: 10px 15px;
            margin-right: 10px;
            border-radius: 50%;

        }

        .stepnumActive {
            background-color: #a2ef4d;
        }
    }

    .next {
        padding: 5px 15px;
        background-color: #a4adb3;
        color: white;
        width: auto;
        text-align: center;
        border-radius: 5px;
        display: grid;
        place-self: center;
    }
}
</style>