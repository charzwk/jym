<template>
    <div class="contain">
        <div class="box">
            <!-- 右侧 -->
            <div class="left">
             
                <!-- 第二模块 人员信息-->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>人工信息</h2>
                        </div>

                    </div>
                    <div class="personlist" v-for="item in list1">
                        <div>项目： {{ item.name }}</div>
                        <div>项目编码： {{ item.code }}</div>
                        <div>参与人数： {{ item.personnum }}</div>
                        <div>全部工时： {{ item.totalhour }}</div>
                        <div>全部费用： {{ item.totalcost }}</div>

         
                    </div>
                </div>
                <!-- 设备信息 -->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>设备信息</h2>
                        </div>
                        <!-- <div class="addbtn" @click="dialogvisbel2 = true"><el-button type="primary">新增</el-button></div> -->
                    </div>
                    <div class="personlist" v-for="item in list2">
                        <div>设备名称： {{ item.devname }}</div>
                        <div>设备类型： {{ item.typerate }}</div>
                        <div>设备时间： {{ item.year }}</div>
                        <div>单价: {{ item.cost }}</div>
                        <div>人员: {{ item.person }}</div>
                      
                    </div>
                </div>

                <!-- 投入计划 -->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>材料信息</h2>
                        </div>
                        
                    </div>
                    <div class="personlist" v-for="item in list3">
                        <div>日期： {{ item.year }}</div>
                        <div>材料名称： {{ item.name }}</div>
                        <div>数量： {{ item.num }}</div>
                        <div>项目: {{ item.proname }}</div>
                        <div>金额： {{ item.acount }}</div>
                      
                    </div>
                </div>

                    <!-- 投入计划 -->
                    <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>工资信息</h2>
                        </div>
                        
                    </div>
                    <div class="personlist" v-for="item in list4">
                        <div>姓名： {{ item.name }}</div>
                        <div>日期： {{ item.year }}</div>
                        <div>应出勤工时： {{ item.hour1 }}</div>
                        <div>实际工时: {{ item.hour2 }}</div>
                        <div>工资： {{ item.finalweges }}</div>
                      
                    </div>
                </div>

                <!-- 第三模块 文件列表 -->
                <!-- <div class="threeMolde">
                    <div class="newadd">
                        <div>
                            <h2>文件信息</h2>
                        </div>
                        <div class="addbtn" @click="dialogvisbel = true"><el-button type="primary">新增</el-button></div>
                    </div>
                    <div class="threeitem" v-for="item in filesList">
                        <div>姓名：{{ item.name }}</div>
                        <div>文件：{{ item.file }}</div>
                        <div>创建日期：{{ item.time }}</div>
                        <div>部门：{{ item.dep }}</div>
                        <div class="btns">
                            <div class="preview"> <i class="fas fa-eye"></i>预览</div>
                            <div class="upload"> <i class="fas fa-upload"></i>上传</div>
                            <div class="down"> <i class="fas fa-download"></i>下载</div>
                            <div class="del"> <i class="fas fa-trash"></i>删除</div>

                        </div>
                    </div>

                </div> -->
            </div>
            <!-- 左侧 -->
            <div class="right">
                <div class="processinfo">
                    <h2>流程信息</h2>
                    <div class="proitem" v-for="item in processInfo">
                        <div class="protitle">
                            <div class="" style="font-size: 20px;">{{ item.title }}</div>
                            <div class="state  ">{{ item.state }}</div>
                            <!-- <div class=" state2" v-if="item.state == '审批中'">{{ item.state }}</div>
                            <div class=" state3" v-if="item.state == '待领取'">{{ item.state }}</div>
                            <div class=" state4" v-if="item.state == '进行中'">{{ item.state }}</div> -->
                        </div>
                        <!-- <div style="display: grid;grid-template-columns: 1fr auto;">
                            <div class="" >{{ item.title }}</div>
                            <div class="">{{ item.state }}</div>
                        </div> -->

                        <!-- 下面 -->
                        <div class="moreinfo">
                            <div class="node">最终节点：{{ item.nodeName }}</div>
                            <div class="initInfo">
                                <span style="width: 20px;height: 20px;"><img
                                        style="width: 20px;height: 20px;transform: translateY(4px);"
                                        src="@/imgs/person.png" alt=""></span>
                                发起人：{{ item.initiated }} &nbsp;&nbsp;{{ item.initiatedTime }}
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 弹框 -->
            <el-dialog title="新增人员" :visible.sync="dialogvisbel" width="50%">
                <el-form ref="form" :model="form" label-width="100px">
                    <!-- 第一步 项目信息 -->
                    <div>
                        <el-form-item label="人员姓名">
                            <el-select v-model="form2.info1">
                                <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                    }}</el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="部门">
                            <el-select v-model="form2.dep">
                                <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                    }}</el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="上传时间">
                            <el-date-picker v-model="form2.info2" type="date" placeholder="请选择上传时间"
                                style="width: 400px;">
                            </el-date-picker>
                        </el-form-item>
                    </div>
                    <el-form-item>
                        <div class="form-buttons">
                            <el-button type="primary" @click="onSubmit">保存</el-button>
                            <el-button @click="dialogvisbel = false">取消</el-button>
                        </div>
                    </el-form-item>
                </el-form>
            </el-dialog>
            <!-- 新增设备弹框 -->
            <el-dialog title="新增设备" :visible.sync="dialogvisbel2" width="50%">
                <el-form ref="form" :model="form" label-width="100px">
                    <!-- 第一步 项目信息 -->
                    <div>
                        <el-form-item label="设备名称">
                            <el-select v-model="form2.info1">
                                <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                    }}</el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="费用">
                            <el-input v-model.number="form2.cost" placeholder="请输入费用"></el-input>
                        </el-form-item>
                        <el-form-item label="备注">
                            <el-input v-model="form2.cost" placeholder="请输入备注"></el-input>
                        </el-form-item>
                        <el-form-item label="添加时间">
                            <el-date-picker v-model="form2.info2" type="date" placeholder="请选择上传时间"
                                style="width: 400px;">
                            </el-date-picker>
                        </el-form-item>
                    </div>
                    <el-form-item>
                        <div class="form-buttons">
                            <el-button type="primary" @click="onSubmit">保存</el-button>
                            <el-button @click="dialogvisbel2 = false">取消</el-button>
                        </div>
                    </el-form-item>
                </el-form>
            </el-dialog>

            <!-- 新增计划弹框 -->
            <el-dialog title="新增计划费用" :visible.sync="dialogvisbel3" width="50%">
                <el-form ref="form" :model="form" label-width="100px">
                    <!-- 第一步 项目信息 -->
                    <div>
                        <el-form-item label="事项">
                            <el-select v-model="form2.info1">
                                <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                    }}</el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="费用">
                            <el-input v-model.number="form2.cost" placeholder="请输入费用"></el-input>
                        </el-form-item>
                        <el-form-item label="备注">
                            <el-input v-model="form2.cost" placeholder="请输入备注"></el-input>
                        </el-form-item>
                        <el-form-item label="添加时间">
                            <el-date-picker v-model="form2.info2" type="date" placeholder="请选择上传时间"
                                style="width: 400px;">
                            </el-date-picker>
                        </el-form-item>
                    </div>
                    <el-form-item>
                        <div class="form-buttons">
                            <el-button type="primary" @click="onSubmit">保存</el-button>
                            <el-button @click="dialogvisbel3 = false">取消</el-button>
                        </div>
                    </el-form-item>
                </el-form>
            </el-dialog>
            <!-- 调研 -->
            <el-dialog title="调研" :visible.sync="dialogvisbel4" width="50%">
                <el-table :data="form3" style="width: 100%">
                            <el-table-column prop="title" label="报告标题">
                            </el-table-column>
                            <el-table-column prop="summy" label="简介">
                            </el-table-column>
                            <el-table-column prop="res" label="结论">
                            </el-table-column>
                            <el-table-column prop="jianyi" label="建议">
                            </el-table-column>
                            <el-table-column prop="createby" label="创建人">
                            </el-table-column>
                            <el-table-column prop="state" label="状态">
                            </el-table-column>
                            <el-table-column prop="time" label="创建日期">
                            </el-table-column>
                            <el-table-column prop="file" label="文件">
                            </el-table-column>
                            <el-table-column prop="name" label="操作">
                                <template slot-scope="scope">
                                    <el-button @click="viewPdf" type="primary" size="mini">查看文件</el-button>
                                    <!-- <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button> -->
                                </template>
                            </el-table-column>

                        </el-table>
                <el-form ref="form" :model="form" label-width="100px" style="display: none;">
                    <div>
                        <el-form-item label="报告标题">
                            <el-input v-model="form3.title" placeholder="请输入报告标题" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="简介">
                            <el-input v-model="form3.summy" placeholder="请输入简介" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="结论">
                            <el-input v-model="form3.res" placeholder="请输入结论" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="建议">
                            <el-input v-model="form3.jianyi" placeholder="请输入建议" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="创建人">
                            <el-input v-model="form3.createby" placeholder="请输入创建人" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="状态">
                            <el-input v-model="form3.state" placeholder="请输入状态" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="创建日期">
                            <el-input v-model="form3.time" placeholder="请输入创建日期" disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="文件">
                            <div >{{ form3.file }}</div>
                        </el-form-item>
                    </div>
                    <el-form-item>
                        <div class="form-buttons">
                            <!-- <el-button type="primary" @click="onSubmit">保存</el-button> -->
                            <el-button @click="dialogvisbel4 = false">关闭</el-button>
                        </div>
                    </el-form-item>
                </el-form>


            </el-dialog>
        </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            form: {
                info2: 'ceshimkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
            },//概要信息
            form2: {}, //文件弹框
            list1: [
              {code:'0006',name:'项目a',personnum:'156',totalhour:'1560',totalcost:'156000'},
            //   {code:'0006',name:'项目d',personnum:'254',totalhour:'25400',totalcost:'254000'},
            //   {code:'0006',name:'项目g',personnum:'156',totalhour:'1560',totalcost:'156000'},
                
            ],
            list2: [
              {year:'2024-10-11',cost:'1500',typerate:'人员',person:'张三',devname:'机器人一号',rateamount:'150',rate:'100%'},
            //   {year:'2024-10-11',cost:'1500',typerate:'设备',person:'张三',devname:'机器人一号',rateamount:'150',rate:'100%'},
             
            ],
            list3: [
                { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目AC',rate:'100%',acount:'1000' },
                // { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目C',rate:'100%',acount:'1000' },
                // { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目d',rate:'100%',acount:'1000' },
            ],
            list4: [
                { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx' ,finalweges:'5700'},
                //  { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                //  hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                //  projectwages: '1200', pigeonhole: 'xx',finalweges:'5800' },
                //  { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                //  hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                //  projectwages: '1200', pigeonhole: 'xx',finalweges:'5650' },
                
            ],
            form3:[
            {
                title:'报告xxx',
                summy:'简介xxxxccc',
                res:'bucuo',
                jianyi:'都很好',
                createby:'张三',
                state:'已通过',
                time:'2022-10-10 12-20',
                file:'ceshi.pdf'
            },
            {
                title:'报告x222x',
                summy:'简介xaaaaccc',
                res:'bucuo',
                jianyi:'都很好',
                createby:'里斯',
                state:'已通过',
                time:'2022-10-10 12-20',
                file:'ceshi.pdf'
            },
            ],
            filesList: [
                { id: 1, name: '鸡哥', file: '预告.pdf', time: '2002-10-10 12-22', dep: '开发部' },
                { id: 1, name: '坤哥', file: '测试.pdf', time: '2002-10-10 12-22', dep: '调研部' },
                { id: 1, name: '类型', file: '预测.pdf', time: '2002-10-10 12-22', dep: '测试部' },
            ],
            processInfo: [
                { id: 1, title: '张三', state: '提交审批', nodeName: '董事会', initiated: '刘星', initiatedTime: '2020-11-11 12-22' },
                { id: 1, title: '里斯', state: '审批通过', nodeName: '科信部审批', initiated: '张三', initiatedTime: '2020-11-13 12-22' },
                { id: 1, title: '王五', state: '审批通过', nodeName: '市场部审批', initiated: '李xx', initiatedTime: '2020-11-15 12-22' },
                { id: 1, title: '赵六', state: '进行中', nodeName: '科研部进行中', initiated: '张xx', initiatedTime: '2020-11-21 12-22' },
            ],
            personlist: [
                { id: 1, name: '张三' },
                { id: 2, name: '里斯' },
                { id: 3, name: '王五' },
            ],
            dialogvisbel: false,
            dialogvisbel2: false,
            dialogvisbel3: false,
            dialogvisbel4: false,

            projectPersons: [
                { id: 1, name: '张三', role: '测试', dep: '测试部' },
                { id: 2, name: '里斯', role: '开发', dep: '开发部' },
                { id: 3, name: '无望', role: '运行', dep: '运营部' },
            ],
            projectPersons2: [
                { id: 1, name: '机器A', role: '200.00', dep: '无' },
                { id: 2, name: '机器b', role: '120.11', dep: '注意保养' },
                { id: 3, name: '机器T800', role: '100000', dep: '使用注意安全' },
            ],
            projectPersons3: [
                { id: 1, name: '需要机器', role: '90000', dep: '需要设备支持' },
                { id: 2, name: '需要物资', role: '10000', dep: '无' },

            ]

        }
    }
}
</script>

<style scoped lang="scss">
.newadd {
    display: grid;
    grid-template-columns: 1fr auto;
    border-bottom:  1px solid #c0bebe;
}

.personlist {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    padding: 10px 0;
}

.oto {
    display: grid;
    grid-template-columns: 1fr 1fr;
}

.addbtn {
    color: rgb(70, 70, 209);
    // background-color: rgb(86, 86, 240);
    display: grid;
    align-items: center;
}

i {
    margin-right: 5px;
}

.preview {
    color: rgb(70, 70, 209);
}

.del {

    color: rgb(212, 52, 52);
    // color: rgb(70, 70, 209);
}

.contain {
    padding: 10px 30px;

    .box {
        display: grid;
        grid-template-columns: 3fr 1fr;
        gap: 10px;
    }

    .btns {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        gap: 5px;
    }

    .oneModel {
        background-color: #eee;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 10px;

        .oneinfo {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            padding: 10px 0;

            // place-items: center;
            .oneitem {}
        }
    }

    .twoModel {
        background-color: #eee;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 10px;

        .twoitem {
            padding: 10px 0;
            // color: red;
        }

    }

    .threeMolde {
        background-color: #eee;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 10px;

        .threeitem {
            display: grid;
            grid-template-columns: 1fr 1fr 2fr 1fr 2fr;
            padding: 10px 0;

            i {
                margin-right: 5px;
            }

            .preview {
                color: rgb(70, 70, 209);
            }

            .del {

                color: rgb(212, 52, 52);
                // color: rgb(70, 70, 209);
            }

            .upload {
                color: #e73ebd;
                color: rgb(70, 70, 209);
            }

            .down {
                color: #a3c52a;
                color: rgb(70, 70, 209);
            }
        }
    }

    .right {
        .processinfo {
            background-color: #eee;
            padding: 10px;

            .proitem {
                border-radius: 10px;
                background-color: #fff;
                padding: 10px;
                margin: 10px 0;

                .protitle {
                    display: grid;
                    grid-template-columns: 1fr auto;

                    .title {
                        font-size: 20px;
                    }

                    .state {
                        background-color: #cee1b0;
                        color: #5b9106;
                        border-radius: 5px;
                        padding: 1px 3px;
                    }
                }

                .moreinfo {
                    color: #979595;
                    font-size: 16px;
                    margin-top: 10px;

                    .node {
                        padding-bottom: 5px;
                    }
                }
            }
        }
    }

    .state1 {
        background-color: #cee1b0;
        color: #5b9106;
        border-radius: 5px;
        padding: 1px 3px;
    }

    .state2 {
        background-color: #a0e0f0;
        color: #057981;
        border-radius: 5px;
        padding: 1px 3px;
    }

    .state3 {
        background-color: #f087bb;
        color: #96287a;
        border-radius: 5px;
        padding: 1px 3px;
    }

    .state4 {
        background-color: #dbb181;
        color: #92761c;
        border-radius: 5px;
        padding: 1px 3px;
    }
}
</style>