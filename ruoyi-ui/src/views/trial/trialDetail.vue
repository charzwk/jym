<template>
    <div class="contain">
        <div class="box">
            <!-- 右侧 -->
            <div class="left">
                <!-- 第一栏 -->
                <div class="one">
                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>00013</div>
                            <div class="col9">编号</div>
                        </div>
                    </div>

                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>已通过</div>
                            <div class="col9">状态</div>
                        </div>
                    </div>

                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>李xx</div>
                            <div class="col9">申请人</div>
                        </div>
                    </div>

                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>00013</div>
                            <div class="col9">申请时间</div>
                        </div>
                    </div>


                </div>
                <!-- 标题 -->
                <div class="dialoginfo" style="margin: 10px  0 ;">
                    <div class="dtitle">项目基础情况
                        <div class="close"><img src="@/imgs/close.png" alt=""></div>
                    </div>
                </div>

                <!-- 基础信息 -->
                <el-row :gutter="10">
                    <el-col :span="12">
                        <div>
                            <div class="ddname">试验名称</div>
                            <div class="bge">优化搜索引擎性能</div>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <el-row :gutter="10">
                            <el-col :span="12">
                                <div>
                                    <div class="ddname">项目负责人</div>
                                    <div class="bge">李sir</div>
                                </div>
                            </el-col>
                            <el-col :span="12">
                                <div>
                                    <div class="ddname">负责人电话</div>
                                    <div class="bge">192xxxxxxx</div>
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
                                    <div class="bge">张xx</div>
                                </div>
                            </el-col>
                            <el-col :span="12">
                                <div class="ddname">审批人电话</div>
                                <div class="block">
                                    <div class="bge">123xxxxxx</div>
                                </div>
                            </el-col>
                        </el-row>
                    </el-col>
                    <el-col :span="12">
                        <el-row :gutter="10">
                            <el-col :span="12">
                                <div class="ddname">项目类型</div>
                                <div class="bge">测试类</div>
                            </el-col>

                            <el-col :span="12">
                                <div class="ddname">是否专项</div>
                                <div class="bge">是</div>
                            </el-col>
                        </el-row>
                    </el-col>
                </el-row>



                <!-- 标题 -->
                <div class="dialoginfo" style="margin: 10px  0 ;">
                    <div class="dtitle">物料信息
                        <div class="close"><img src="@/imgs/close.png" alt=""></div>
                    </div>
                </div>
                <!-- 人员-->
                <div class="pd10">
                    <div class="ddname">物料信息</div>
                    <div class="mark">试验所需要的物料概况信心</div>
                    <el-table :data="tableData" style="width: 100%">
                        <el-table-column type="index" label="序号">
                        </el-table-column>
                        <el-table-column prop="name" label="物料名称">
                        </el-table-column>
                        <el-table-column prop="role" label="物料费用">
                        </el-table-column>
                        <el-table-column prop="department" label="单位">
                        </el-table-column>
                        <el-table-column prop="note" label="备注">
                        </el-table-column>
                    </el-table>
                </div>







            </div>
            <!-- 左侧 -->
            <div class="right" style="background-color: #f9fafc;">

                <div class="process">
                    <div class="processitem">
                        <div class="mark">2023-9-27 09:22</div>
                        <div class="processinfo">
                            <div class="proheader">申请人</div>
                            <div class="probody">
                                <div class="proname"> <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/person.png" alt=""></span> sir发起新的</div>
                                <div class="pronnum">
                                    <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/repare.png" alt=""></span>

                                    18
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="processitem">
                        <div class="mark">2023-9-27 09:22</div>
                        <div class="processinfo">
                            <div class="proheader">审批和流程</div>
                            <div class="probody">
                                <div class="proname success"> <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/person.png" alt=""></span> sir发起新的</div>
                                <div class="pronnum">
                                    <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/repare.png" alt=""></span>
                                    18
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="processitem">
                        <div class="mark">2023-9-27 09:22</div>
                        <div class="processinfo">
                            <div class="proheader">抄送项目申请结果</div>
                            <div class="probody">
                                <div class="proname"> <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/person.png" alt=""></span> 抄送项目1名成员</div>
                                <div class="pronnum">
                                    <span style="width: 15px;height: 15px;"><img
                                            style="width: 15px;height: 15px;transform: translateY(2px);"
                                            src="@/imgs/repare.png" alt=""></span>
                                    18
                                </div>
                            </div>
                        </div>
                    </div>
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
                            <div>{{ form3.file }}</div>
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
            cailiaoList: [
                { name: '材料A', count: '100', unit: '个', price: '150', total: '15000' },
                { name: '材料CA', count: '100', unit: '个', price: '150', total: '15000' },
                { name: '材料ACC', count: '100', unit: '个', price: '150', total: '15000' },
            ],
            form3: [
                {
                    title: '报告xxx',
                    summy: '简介xxxxccc',
                    res: 'bucuo',
                    jianyi: '都很好',
                    createby: '张三',
                    state: '已通过',
                    time: '2022-10-10 12-20',
                    file: 'ceshi.pdf'
                },
                {
                    title: '报告x222x',
                    summy: '简介xaaaaccc',
                    res: 'bucuo',
                    jianyi: '都很好',
                    createby: '里斯',
                    state: '已通过',
                    time: '2022-10-10 12-20',
                    file: 'ceshi.pdf'
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
            phaseslist: [
                { id: 1, name: '验证阶段' },
                { id: 2, name: '小试阶段' },
                { id: 3, name: '中试阶段' },
                { id: 4, name: '产业化' },
            ],

        }
    }
}
</script>

<style scoped lang="scss">
.newadd {
    display: grid;
    grid-template-columns: 1fr auto;
    border-bottom: 1px solid #c0bebe;
}

.newadd2 {
    display: grid;
    grid-template-columns: 1fr 1fr;

}

.personlist {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr auto;
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