<template>
    <div class="contain">
        <div class="box">
            <!-- 右侧 -->
            <div class="left">
                <!-- 第一模块 -->
                <div class="oneModel">
                    <h2>基本信息</h2>
                    <div class="oneinfo">
                        <div class="oneitem">项目编码：0098111</div>
                        <div class="oneitem">项目名称：测试项目A</div>
                        <div class="oneitem">状态：<span style="color: #5b9106;">申请中</span></div>
                    </div>
                    <div class="oneinfo">
                        <div class="oneitem">发起人：你鸡哥</div>
                        <div class="oneitem">发起时间：2033-20-20 10-22</div>
                        <div class="oneitem">发起人部门：开发部</div>
                    </div>
                    <div class="oneinfo">
                        <div class="oneitem">目标：实现xxxx</div>
                        <div class="oneitem">研究内容分解：1，xxx2,ssss</div>
                        <div class="oneitem">设备需求：需要机器A等</div>
                    </div>
                </div>
                <!-- 第二模块 人员信息-->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>人员信息</h2>
                        </div>
                        <div class="addbtn" @click="dialogvisbel = true"><el-button type="primary">新增</el-button></div>
                    </div>
                     <div class="personlist" v-for="item  in projectPersons">
                        <div>姓名： {{ item.name }}</div>
                        <div>角色： {{ item.role }}</div>
                        <div>部门： {{ item.dep }}</div>
                        <div class="btns">
                            <div class="preview"> <i class="fas fa-edit"></i>编辑</div>
                            <div class="del"> <i class="fas fa-trash"></i>移除</div>

                        </div>
                     </div>
                </div>
                <!-- 设备信息 -->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>设备信息</h2>
                        </div>
                        <div class="addbtn" @click="dialogvisbel2 = true"><el-button type="primary">新增</el-button></div>
                    </div>
                     <div class="personlist" v-for="item  in projectPersons2">
                        <div>设备名称： {{ item.name }}</div>
                        <div>费用： {{ item.role }}</div>
                        <div>备注： {{ item.dep }}</div>
                        <div class="btns">
                            <div class="preview"> <i class="fas fa-edit"></i>编辑</div>
                            <div class="del"> <i class="fas fa-trash"></i>移除</div>
                        </div>
                     </div>
                </div>

                <!-- 投入计划 -->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>投入计划信息</h2>
                        </div>
                        <div class="addbtn" @click="dialogvisbel3 = true"><el-button type="primary">新增</el-button></div>
                    </div>
                     <div class="personlist" v-for="item  in projectPersons3">
                        <div>事项： {{ item.name }}</div>
                        <div>费用： {{ item.role }}</div>
                        <div>备注： {{ item.dep }}</div>
                        <div class="btns">
                            <div class="preview"> <i class="fas fa-edit"></i>编辑</div>
                            <div class="del"> <i class="fas fa-trash"></i>移除</div>
                        </div>
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
                           <el-input v-model.number="form2.cost" placeholder="请输入费用" ></el-input>
                        </el-form-item>
                        <el-form-item label="备注">
                           <el-input v-model="form2.cost" placeholder="请输入备注" ></el-input>
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
                           <el-input v-model.number="form2.cost" placeholder="请输入费用" ></el-input>
                        </el-form-item>
                        <el-form-item label="备注">
                           <el-input v-model="form2.cost" placeholder="请输入备注" ></el-input>
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
            
            projectPersons:[
                {id:1,name:'张三',role:'测试',dep:'测试部'},
                {id:2,name:'里斯',role:'开发',dep:'开发部'},
                {id:3,name:'无望',role:'运行',dep:'运营部'},
            ],
            projectPersons2:[
                {id:1,name:'机器A',role:'200.00',dep:'无'},
                {id:2,name:'机器b',role:'120.11',dep:'注意保养'},
                {id:3,name:'机器T800',role:'100000',dep:'使用注意安全'},
            ],
            projectPersons3:[
                {id:1,name:'需要机器',role:'90000',dep:'需要设备支持'},
                {id:2,name:'需要物资',role:'10000',dep:'无'},
                
            ]

        }
    }
}
</script>

<style scoped lang="scss">
.newadd {
    display: grid;
    grid-template-columns: 1fr auto;
}
.personlist{
    display: grid;
    grid-template-columns: repeat(4,1fr);
    padding: 10px 0 ;
}
.oto{
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