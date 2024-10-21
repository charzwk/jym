<template>
    <div>
        <!-- header -->
        <div class="header">
            <!-- <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button> -->
            <div class="serachModel">
                <div>
                    <el-select v-model="form.info3" placeholder="请选择项目">
                        <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                    </el-select>
                </div>
            </div>
        </div>

        <!-- 第二模块 人员信息-->
        <div class="twoModel">
            <div style="  border-bottom:  1px solid #c0bebe;">
                <h2>项目信息</h2>
            </div>
            <div class="personlist" v-for="item in projectPersons">
                <div>项目名称： {{ item.name }}</div>
                <div>项目编码： {{ item.code }}</div>
                <div>创建日期： {{ item.time }}</div>
              
            </div>
        </div>

        <div class="box">
            <div class="left maincol">
                <div class="oneLeave ">
                    <span style="width: 15px;height: 15px;"><img
                            style="width: 15px;height: 15px;transform: translateY(1px);" src="@/imgs/downarr.png"
                            alt=""></span>
                    1.试验前期阶段
                </div>
                <div class="infos">
                    <div class="infoitem" v-for="item in beforeInfo"> {{ item.title }}</div>
                </div>

                <div class="oneLeave ">
                    <span style="width: 15px;height: 15px;"><img
                            style="width: 15px;height: 15px;transform: translateY(1px);" src="@/imgs/downarr.png"
                            alt=""></span>
                   2.验证阶段 （2023/05/15-2025/05/31）
                </div>
                <div class="infos">
                    <div class="infoitem"  :style="{ color: item.id === 1 ? 'blue' : '' }" v-for="item in afterInfo"> {{ item.title }}</div>
                </div>

                <div class="oneLeave ">
                    <span style="width: 15px;height: 15px;"><img
                            style="width: 15px;height: 15px;transform: translateY(1px);" src="@/imgs/downarr.png"
                            alt=""></span>
                   3. 小试阶段 （2023/06/01-2025/06/31）
                </div>
                <div class="infos">
                    <div class="infoitem"  :style="{ color: item.id === 1 ? 'blue' : '' }" v-for="item in afterInfo2"> {{ item.title }}</div>
                </div>


               

            </div>
            <div class="right">
                 <!-- 第一模块 -->
                 <div class="oneModel">
                    <div class="newadd">
                        <div style="border-bottom: 1px solid #c0bebe;"> <h2>基本信息</h2></div>
                        <div class="addbtn del" style="font-size: 20px;" @click="dialogvisbel4 = true" v-if="false">调研</div>
                  
                    </div>
                 
                    <div class="oneinfo">
                        <div class="oneitem">试验名称：试验领料</div>
                        <div class="oneitem">任务阶段：验证阶段
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
                        <div style="border-bottom: 1px solid #c0bebe;">
                            <h2>材料信息</h2>
                        </div>
                        <!-- <div class="addbtn" @click="dialogvisbel = true"><el-button type="primary">新增</el-button>
                            <el-button type="success">导入excel</el-button>
                        </div> -->
                    </div>
                    <div class="personlist" v-for="item in cailiaoList">
                        <div>材料名称： {{ item.name }}</div>
                        <div>数量： {{ item.count }}</div>
                        <div>单数： {{ item.unit }}</div>
                        <div>单价： {{ item.price }}</div>
                        <div>金额: {{ item.total }}</div>
                        <!-- <div class="btns">
                            <div class="preview"> <i class="fas fa-edit"></i>编辑</div>
                            <div class="del"> <i class="fas fa-trash"></i>移除</div>

                        </div> -->
                    </div>
                </div>

            </div>
        </div>
    </div>

</template>

<script>
export default {
    data() {
        return {
            form: {},
            phaseslist: [],
            projectPersons:[
                {name:'测试项目',code:'00001',time:'2024-10-11 12:00'}
            ],
            cllist:[
                {name:'材料测试',price:'200',time:'2024-10-11 12:00'}
            ],
            cailiaoList:[
                {name:'材料A',count:'100',unit:'个',price:'150',total:'15000'},
                {name:'材料CA',count:'100',unit:'个',price:'150',total:'15000'},
                {name:'材料ACC',count:'100',unit:'个',price:'150',total:'15000'},
            ],

            beforeInfo: [
                { time: '2024-01-01', title: '1.1 2024年1月11日调研报告' },
                { time: '2024-02-01', title: '1.2 2024年2月11日项目申报书' },
                { time: '2024-03-01', title: '1.3 2024年3月11日项目任务书' },
            ],
            afterInfo: [
                { time: '2024-01-01', title: '2.1 2024年4月11日试验方案 ' },
                {id:1, time: '2024-02-01', title: '2.2 2024年5月11日试验领料 ' },
                { time: '2024-03-01', title: '2.3 2024年6月11日试验记录' },
                { time: '2024-04-01', title: '2.4 2024年7月11日人员工时记录' },
                { time: '2024-04-01', title: '2.4 2024年8月11日设备工时记录' },
            ],
            afterInfo2: [
                { time: '2024-01-01', title: '2.1 2024年9月11日试验方案 ' },
                {time: '2024-02-01', title: '2.2 2024年10月11日试验领料 ' },
                { time: '2024-03-01', title: '2.3 2024年11月01日试验记录' },
                { time: '2024-04-01', title: '2.4 2024年11月30日人员工时记录' },
                { time: '2024-04-01', title: '2.4 2024年12月11日设备工时记录' },
            ]
        }

    },
    methods: {

    }
}
</script>

<style scoped lang="scss">
.maincol {
    color: #a3a1a1;
}

.header {

    display: grid;
    grid-template-columns: auto 1fr;
    margin-bottom: 10px;
    margin-top: 10px;

    .serachModel {
        justify-self: end;
    }

}

.box {
    display: grid;
    grid-template-columns: 1fr 4fr;
    gap: 10px;
    padding: 10px;
    margin: 10px;

    .oneLeave {
        font-size: 18px;
    }
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
        .personlist{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr 1fr ;
            padding: 10px 0 ;
        }

    }
</style>