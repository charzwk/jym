<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button>
            <div class="serachModel">
                <div> <el-input placeholder="请输入内容" suffix-icon="el-icon-search" v-model="input1">
                    </el-input></div>
            </div>
        </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="试验名称">
            </el-table-column>
            <el-table-column prop="recordname" label="记录人">
            </el-table-column>
            <el-table-column prop="time" label="记录时间">
            </el-table-column>
            <el-table-column prop="remark" label="备注">
            </el-table-column>
     
            <el-table-column prop="name" label="操作" width="220">
                <template slot-scope="scope" style="display: grid;grid-template-columns: 1fr 1fr 1fr;">

                    <el-button @click="toDetail" size="mini">查看</el-button>
                    <el-button @click="dialogvisbel = true" type="primary" size="mini">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog title="新增试验工时" :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div v-if="false">
                 
                    <el-form-item label="试验名称">
                        <el-select v-model="form.info3" placeholder="请选择试验">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="记录人">
                        <el-select v-model="form.info3" placeholder="请选择记录人">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="记录时间">
                        <el-date-picker v-model="form.info2" type="datetime" placeholder="请选择记录时间"
                                style="width: 400px;">
                            </el-date-picker>
                      
                    </el-form-item>

                    <el-form-item label="备注">
                        <el-input v-model="form.info11" type="text"  placeholder="请输入备注"></el-input>
                    </el-form-item>
                 
        
                    <!-- <el-form-item label="创建时间">
                        <el-date-picker v-model="dateRange" type="datetime"  placeholder="请选择时间"
                             style="width: 400px;">
                        </el-date-picker>
                    </el-form-item> -->
                </div>

                     <!-- newlayout -->
                     <div class="mydialogInfo">
                    <div class="closedilog" @click="dialogvisbel = false;">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">新增试验记录</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">记录信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                        </div>

                        <div class="ddetail">
                            <!-- 第一列 -->
                            <el-row :gutter="10">
                                <el-col :span="12">
                                    <!-- -->

                                    <el-row :gutter="10">
                                        <el-col :span='12'>
                                            <div>
                                                <div class="ddname">关联项目</div>
                                                <div><el-input v-model="form.name" placeholder="请选择项目"></el-input></div>
                                            </div>
                                        </el-col>
                                        <el-col :span='12'>
                                            <div>
                                                <div class="ddname">记录标题</div>
                                                <div><el-input v-model="form.name" placeholder="请输入任务书标题"></el-input>
                                                </div>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">记录人</div>
                                                <div>
                                                    <el-select v-model="form.person" placeholder="请选择负责人">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
                                                </div>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">所属部门</div>
                                                <div>
                                                    <el-select v-model="form.dep" placeholder="请选择部门">
                                                        <el-option v-for="item in personlist" :label="item.name"
                                                            :value="item.id"></el-option>
                                                    </el-select>
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
                                            <div class="ddname">记录时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem1" type="datetime"
                                                    placeholder="选择开始日期时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">记录备注</div>
                                            <div class="block">
                                                <el-input v-model="form.remark"  placeholder="请输入备注"></el-input>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">状态</div>
                                            <el-select v-model="form.typename" placeholder="请选择状态">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>

                                        <el-col :span="12">
                                            <div class="ddname">专项</div>
                                            <el-select v-model="form.iszx" placeholder="是否专项">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>

                  


                           
                            <!-- 投入费用 -->
                            <div class="pd10">
                                <div class="ddname">上传附件</div>
                                <div class="mark">记录人上传附件</div>
                                <div class="pbb">
                                    <el-button type="primary" @click="addRow"
                                        style="background-color: #fb9337; border-color: #fb9337;">+添加新行</el-button>
                                </div>
                                <el-table :data="list3" border style="width: 100%">
                                    <!-- 序号列 -->
                                    <el-table-column type="index" label="序号" width="50">
                                    </el-table-column>

                                    <!-- 姓名列，使用 el-select 进行选择 -->
                                    <el-table-column prop="name" label="文件名称">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.name" placeholder="请输入费用事项"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 角色列，使用 el-select 进行选择 -->
                                    <el-table-column prop="role" label="上传人">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.role" placeholder="请输入金额"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 备注列，使用 el-input 进行输入 -->
                                    <el-table-column prop="remark" label="备注">
                                        <template slot-scope="scope">
                                            <el-input v-model="scope.row.remark" placeholder="请输入备注"></el-input>
                                        </template>
                                    </el-table-column>

                                    <!-- 操作列，用于删除选中行 -->
                                    <el-table-column label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button type="danger" @click="deleteRow(scope.$index)">删除</el-button>
                                        </template>
                                    </el-table-column>

                                </el-table>
                            </div>


                            <div class="savebtn">
                                <el-button style="color: white;background-color: #fb9337;"
                                    @click="saveinfo">保存</el-button>
                                <el-button @click="dialogvisbel = false">取消</el-button>
                            </div>


                        </div>

                    </div>

                </div>


           
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
            phaseslist:[
                {id:1,name:'验证阶段'},
                {id:2,name:'小试阶段'},
                {id:3,name:'中试阶段'},
                {id:4,name:'产业化'},
            ],
            input1: '',
            personlist: [
                { id: 1, name: '张三' },
                { id: 2, name: '里斯' },
                { id: 3, name: '王五' },
            ],
            personSelect: '',
            personSelect2: '进行中',
            dateRange: '',
            dialogvisbel: false,
            tableData: [
                { name: '试验测试11', recordname:'张三',time:'2024-10-11 12:00',remark: 'xxxx' },
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
            fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' },
             { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }]

        }
    },
    methods: {
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
        toDetail(url){
            window.open(url,'_blank')
        },
        toDetail(){
            this.$router.push('/trial/recordDetail')
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
    grid-template-columns: auto 1fr;
    margin-bottom: 10px;
    margin-top: 10px;

    .serachModel {
        justify-self: end;
    }

}
.file{
    display: grid;
    grid-template-columns: 1fr 1fr;
}
</style>