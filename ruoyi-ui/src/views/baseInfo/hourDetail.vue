<template>
    <div class="contain" >
        <div class="box">
        
            <div class="left">
                <!-- 第一栏 -->
                <div class="one">
                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>{{form.projectCode}}</div>
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
                            <div>{{form.projectLeader}}</div>
                            <div class="col9">创建人</div>
                        </div>
                    </div>

                    <div class="oneitem">
                        <div class="topimg"><img src="@/imgs/person.png" alt=""></div>
                        <div>
                            <div>{{form.createTime}}</div>
                            <div class="col9">创建时间</div>
                        </div>
                    </div>


                </div>
                <!-- 标题 -->
                <div class="dialoginfo" style="margin: 10px  0 ;">
                    <div class="dtitle">项目信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                </div>

                <!-- 基础信息 -->
                <el-row :gutter="10">
                    <el-col :span="12">
                        <div>
                            <div class="ddname">项目名称</div>
                            <div class="bge">{{form.projectName}}</div>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <el-row :gutter="10">
                            <el-col :span="12">
                                <div>
                                    <div class="ddname">项目负责人</div>
                                    <div class="bge">{{form.projectLeader}}</div>
                                </div>
                            </el-col>
                            <el-col :span="12">
                                <div>
                                    <div class="ddname">项目编码</div>
                                    <div class="bge">{{form.projectCode}}</div>
                                </div>
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
                    <div class="mark">所有投入人员信息</div>
                    <el-table :data="form.pmsProjectManHourList" style="width: 100%">
                        <el-table-column type="index" label="序号">
                        </el-table-column>
                        <el-table-column prop="name" label="姓名">
                        </el-table-column>
                        <el-table-column prop="startTime" label="开始时间">
                        </el-table-column>
                        <el-table-column prop="endTime" label="结束时间">
                        </el-table-column>
                        <el-table-column prop="manHour" label="工时">
                        </el-table-column>
                    </el-table>
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


      


      

     
        </div>

    </div>
</template>

<script>
import {getHour} from '@/api/project/hour.js'
export default {
    data() {
        return {
            form: {
                
            },//概要信息
            form2: {}, //文件弹框
            form3:[
            ],
            filesList: [
            ],
            processInfo: [
            ],
            personlist: [
            ],
            dialogvisbel: false,
            dialogvisbel2: false,
            dialogvisbel3: false,
            dialogvisbel4: false,

            projectPersons: [
            ],
            projectPersons2: [
            ],
            projectPersons3: [
            ],
            list: [
            ],
            list2: [
            ],

        }
    },
    created(){
        var id=this.$route.query.id;
        console.log(id);
        
        var _this=this;
        getHour(id).then(res=>{
            console.log('detailHour',res);    
            _this.form=res.data;  
        })

        

    },
    methods:{


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