<template>
    <div class="contain">
        <div class="box">
            <!-- 右侧 -->
            <div class="left">
                <!-- 第一模块 -->
                <div class="oneModel">
                    <div class="newadd">
                        <div> <h2>基本信息</h2></div>
                        <div class="addbtn del" style="font-size: 20px;" @click="dialogvisbel4 = true" v-if="false">调研</div>
                  
                    </div>
                 
                    <div class="oneinfo">
                        <div class="oneitem">试验名称：测试试验aaa</div>
                        <div class="oneitem">任务阶段：
                            <el-select v-model="form.info3" placeholder="请选择阶段">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                        </div>
                        <div class="oneitem">创建人：张三</div>
                        <!-- <div class="oneitem">状态：<span style="color: #5b9106;">申请中</span></div> -->
                    </div>
                    <div class="oneinfo">
                        <div class="oneitem">同步ERP时间：2024-20-12 12:00</div>
                        <div class="oneitem">审ERP单号：006523252</div>
                        <div class="oneitem">创建时间：2024-20-12 12:00</div>
                    </div>
                   
                </div>
                <!-- 第二模块 材料明细-->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>材料信息</h2>
                        </div>
                        <div class="addbtn" @click="dialogvisbel = true"><el-button type="primary">新增</el-button>
                            <el-button type="success">导入excel</el-button>
                        </div>
                    </div>
                    <div class="personlist" v-for="item in cailiaoList">
                        <div>材料名称： {{ item.name }}</div>
                        <div>数量： {{ item.count }}</div>
                        <div>单数： {{ item.unit }}</div>
                        <div>单价： {{ item.price }}</div>
                        <div>金额: {{ item.total }}</div>
                        <div class="btns">
                            <div class="preview"> <i class="fas fa-edit"></i>编辑</div>
                            <div class="del"> <i class="fas fa-trash"></i>移除</div>

                        </div>
                    </div>
                </div>
            
             
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
                <div class="newadd2">
                    <el-button type="success">审批通过</el-button>
                    <el-button type="danger">驳回</el-button>
                </div>
            </div>

            <!-- 弹框 -->
            <el-dialog title="新增材料" :visible.sync="dialogvisbel" width="50%">
                <el-form ref="form" :model="form" label-width="100px">
                    <!-- 第一步 项目信息 -->
                    <div>
                        <el-form-item label="材料名称">
                            <el-input v-model="form.name" placeholder="请输入材料名称"></el-input>
                        </el-form-item>
                        <el-form-item label="数量">
                            <el-input v-model.number="form.count" placeholder="请输入数量"></el-input>
                        </el-form-item>
                        <el-form-item label="单价">
                            <el-input v-model.number="form.count" placeholder="请输入单价"></el-input>
                        </el-form-item>
                        <el-form-item label="单位">
                            <el-input v-model="form.unit" placeholder="请输入单位"></el-input>
                        </el-form-item>
                        <el-form-item label="金额">
                            <el-input v-model="form.unit" placeholder="请输入金额"></el-input>
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
            cailiaoList:[
                {name:'材料A',count:'100',unit:'个',price:'150',total:'15000'},
                {name:'材料CA',count:'100',unit:'个',price:'150',total:'15000'},
                {name:'材料ACC',count:'100',unit:'个',price:'150',total:'15000'},
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

            ],
            phaseslist:[
                {id:1,name:'验证阶段'},
                {id:2,name:'小试阶段'},
                {id:3,name:'中试阶段'},
                {id:4,name:'产业化'},
            ],

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
.newadd2 {
    display: grid;
    grid-template-columns: 1fr 1fr;

}

.personlist {
    display: grid;
    grid-template-columns:1fr 1fr 1fr 1fr 1fr auto;
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
    grid-template-columns: 1fr 1fr;
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