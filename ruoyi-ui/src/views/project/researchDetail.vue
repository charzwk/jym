<template>
    <div class="contain">
        <div class="box">
            <!-- 右侧 -->
            <div class="left" v-if="false">
                <!-- 第一模块 -->
                <div class="oneModel">
                    <h2>基本信息</h2>
                    <div class="oneinfo">
                        <div class="oneitem">调研报告编码：0293028</div>
                        <div class="oneitem">调研报告名称：xxx项目调研报告</div>
                        <div class="oneitem">状态：<span style="color: #5b9106;">进行中</span></div>
                    </div>
                    <div class="oneinfo">
                        <div class="oneitem">创建人：张xxx</div>
                        <div class="oneitem">创建时间：2033-20-20 10-22</div>
                        <div class="oneitem">创建人部门：开发部</div>
                    </div>
                
                </div>
                <!-- 第二模块 调研基本信息-->
                <div class=" twoModel">
                    <h2>概要信息</h2>
                    <div class="twoitem">调研目标：<el-input v-model="form.info2" type="textarea" :rows="4"
                            placeholder="请输入调研目标："></el-input></div>
                    <div class="twoitem">调研内容：<el-input v-model="form.info2" type="textarea" :rows="4"
                            placeholder="请输入调研内容"></el-input></div>
                    <!-- <div class="twoitem">市场需求分析：<el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input></div>
                    <div class="twoitem">竞争对手分析：<el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input></div>
                    <div class="twoitem">调研结论：<el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input></div> -->
                </div>
                <!-- 第三模块 文件列表 -->
                <div class="threeMolde">
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

                </div>
            </div>
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
                            <div>进行中</div>
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
                    <div class="dtitle">调研信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                </div>

                  <!-- 基础信息 -->
                  <el-row :gutter="10">
                    <el-col :span="12">
                        <div>
                            <div class="ddname">调研项目名称</div>
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
                                    <div class="ddname">所属部门</div>
                                    <div class="bge">开发部</div>
                                </div>
                            </el-col>
                        </el-row>

                    </el-col>

                </el-row>

                   <!-- 文本框 -->
              <div>
                <div class="pd10">
                    <div class="ddname">调研说明</div>
                    <div class="mark">调研说明的细节和内容</div>
                    <div class="artcel">
                        本项目的目的是开发一个高效的在线协作平台，<br>
                        <br>
                        旨在为团队提供一个统一的工具来管理和共享项目资源， <br>

                        促进团队成员之间的实时沟通与合作。该平台将整合任务管理、文档编辑、讨论区等功能，<br>
                        <br>
                        以提升团队工作效率和项目管理水平，确保项目的顺利推进和高质量完成。
                    </div>
                </div>

                <div class="pd10">
                    <div class="ddname">调研目标</div>
                    <div class="mark">调研目标的细节和内容</div>
                    <div class="artcel">
                        本项目的目的是开发一个高效的在线协作平台，<br>
                        <br>
                        旨在为团队提供一个统一的工具来管理和共享项目资源， <br>

                        促进团队成员之间的实时沟通与合作。该平台将整合任务管理、文档编辑、讨论区等功能，<br>
                        <br>
                        以提升团队工作效率和项目管理水平，确保项目的顺利推进和高质量完成。
                    </div>
                </div>

                <div class="pd10">
                    <div class="ddname">调研内容</div>
                    <div class="mark">调研目标的细节和内容</div>
                    <div class="artcel">
                        本项目的目的是开发一个高效的在线协作平台，<br>
                        <br>
                        旨在为团队提供一个统一的工具来管理和共享项目资源， <br>

                        促进团队成员之间的实时沟通与合作。该平台将整合任务管理、文档编辑、讨论区等功能，<br>
                        <br>
                        以提升团队工作效率和项目管理水平，确保项目的顺利推进和高质量完成。
                    </div>
                </div>
              </div>


                 <!-- 标题 -->
                 <div class="dialoginfo" style="margin: 10px  0 ;">
                    <div class="dtitle">附件信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                </div>

                <!-- 文件table -->
                      <!-- 人员-->
                <div class="pd10">
                    <div class="ddname">附件信息</div>
                    <div class="mark">上传文件信息</div>
                    <el-table :data="tableData" style="width: 100%">
                        <el-table-column type="index" label="序号">
                        </el-table-column>
                        <el-table-column prop="name" label="文件名">
                        </el-table-column>
                        <el-table-column prop="role" label="上传人">
                        </el-table-column>
                        <el-table-column prop="department" label="上传时间">
                        </el-table-column>
                        <el-table-column prop="note" label="备注">
                        </el-table-column>
                    </el-table>
                </div>

            </div>
            <!-- 左侧 -->
            <div class="right" v-if="false">
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

            <div class="right" style="background-color: #f9fafc;">

<div class="process">
    <div class="processitem">
        <div class="mark">2023-9-27 09:22</div>
        <div class="processinfo">
            <div class="proheader">申请人</div>
            <div class="probody">
                <div class="proname">  <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/person.png" alt=""></span> sir发起新的</div>
                <div class="pronnum">
                    <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/repare.png" alt=""></span>

                    18</div>
            </div>
        </div>
    </div>

    <div class="processitem">
        <div class="mark">2023-9-27 09:22</div>
        <div class="processinfo">
            <div class="proheader">审批和流程</div>
            <div class="probody">
                <div class="proname success">  <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/person.png" alt=""></span> sir发起新的</div>
                <div class="pronnum">
                    <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/repare.png" alt=""></span>
                    18</div>
            </div>
        </div>
    </div>

    <div class="processitem">
        <div class="mark">2023-9-27 09:22</div>
        <div class="processinfo">
            <div class="proheader">抄送项目申请结果</div>
            <div class="probody">
                <div class="proname">  <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/person.png" alt=""></span> 抄送项目1名成员</div>
                <div class="pronnum">
                    <span style="width: 15px;height: 15px;"><img
                        style="width: 15px;height: 15px;transform: translateY(2px);"
                        src="@/imgs/repare.png" alt=""></span>
                    18</div>
            </div>
        </div>
    </div>
</div>

</div>

            <!-- 弹框 -->
            <!-- 弹框 -->
            <el-dialog title="新增文件" :visible.sync="dialogvisbel" width="50%">

                <el-form ref="form" :model="form" label-width="100px">
                    <!-- 第一步 项目信息 -->
                    <div>
                        <el-form-item label="请选择上传人">
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

                        <el-form-item label="附件上传">
                            <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"
                                :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove"
                                multiple :limit="3" :on-exceed="handleExceed" :file-list="[]">
                                <div class="filelist">
                                    <div class="file" v-for="item in fileList">
                                        <div style="color: #2468f2;">{{ item.name }}</div>
                                        <div style="color: #2468f2;justify-self: end;" @click="toDetail(item.url)">编辑
                                        </div>
                                    </div>
                                </div>
                                <el-button size="small" type="primary">点击上传</el-button>
                                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                            </el-upload>
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
        }
    }
}
</script>

<style scoped lang="scss">
.newadd {
    display: grid;
    grid-template-columns: 1fr auto;
}
.newadd2 {
    display: grid;
    grid-template-columns: 1fr 1fr;
}

.addbtn {
    color: rgb(70, 70, 209);
    // background-color: rgb(86, 86, 240);
    display: grid;
    align-items: center;
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