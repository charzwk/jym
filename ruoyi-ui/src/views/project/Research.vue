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
            <el-table-column prop="name" label="项目名称">
            </el-table-column>
            <el-table-column prop="time" label="调研时间">
            </el-table-column>
            <el-table-column prop="target" label="调研目标">
            </el-table-column>
            <el-table-column prop="content" label="调研内容">
            </el-table-column>
            <el-table-column prop="fenxi" label="市场需求分析">
            </el-table-column>
            <el-table-column prop="duishou" label="竞争对手分析">
            </el-table-column>
            <el-table-column prop="res" label="调研结论">
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
        <!-- 弹框 -->
        <el-dialog :visible.sync="dialogvisbel" width="80%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div v-if="false">
                    <el-form-item label="调研时间">
                        <el-date-picker v-model="dateRange" type="daterange" start-placeholder="开始日期"
                            end-placeholder="结束日期" style="width: 400px;">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item label="调研说明">
                        <el-input v-model="form.info11" type="textarea" :rows="4" placeholder="请输入调研说明"></el-input>
                    </el-form-item>

                    <el-form-item label="调研目标">
                        <el-input v-model="form.info1" type="textarea" :rows="4" placeholder="请输入调研目标"></el-input>
                    </el-form-item>

                    <el-form-item label="调研内容">
                        <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input>
                    </el-form-item>

                    <el-form-item label="市场需求分析">
                        <el-input v-model="form.info3" type="textarea" :rows="4" placeholder="请输入市场需求分析"></el-input>
                    </el-form-item>

                    <el-form-item label="竞争对手分析">
                        <el-input v-model="form.info4" type="textarea" :rows="4" placeholder="请输入竞争对手分析"></el-input>
                    </el-form-item>

                    <el-form-item label="调研结论">
                        <el-input v-model="form.info5" type="textarea" :rows="4" placeholder="请输入调研结论"></el-input>
                    </el-form-item>

                    <el-form-item label="当前状态">
                        <el-select v-model="personSelect2">
                            <el-option v-for="item in personlist" :label="item.name" :value="item.id">进行中</el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="附件上传">
                        <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"
                            :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple
                            :limit="3" :on-exceed="handleExceed" :file-list="[]">
                            <div class="filelist">
                                <div class="file" v-for="item in fileList">
                                    <div style="color: #2468f2;">{{ item.name }}</div>
                                    <div style="color: #2468f2;justify-self: end;" @click="toDetail(item.url)">编辑</div>
                                </div>
                            </div>
                            <el-button size="small" type="primary">点击上传</el-button>
                            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                        </el-upload>
                    </el-form-item>
                    <el-form-item label="请选择上传人">
                        <el-select v-model="personSelect">
                            <el-option v-for="item in personlist" :label="item.name" :value="item.id">{{ item.name
                                }}</el-option>
                        </el-select>
                    </el-form-item>

                </div>


                <!-- newlayout -->
                <div class="mydialogInfo" v-else>
                    <div class="closedilog" @click="dialogvisbel = false;">
                        <img src="@/imgs/closedialog.png" alt="">
                    </div>
                    <div class="br">
                        <div class="dialogheader">
                            <div class="bgmask"></div>
                            <div style="padding: 10px;">新增调研</div>
                        </div>
                    </div>

                    <div class="infoDetail">
                        <div class="dialoginfo">
                            <div class="dtitle">调研信息
                                <div class="close"><img src="@/imgs/close.png" alt=""></div>
                            </div>
                        </div>

                        <div class="ddetail">
                            <!-- 第一列 -->
                            <el-row :gutter="10">
                                <el-col :span="12">
                                    <div>
                                        <div class="ddname">项目名称</div>
                                        <div>
                                            <el-select v-model="form.person" placeholder="请选择调研项目">
                                                <el-option v-for="item in personlist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </div>
                                    </div>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div>
                                                <div class="ddname">调研发起人</div>
                                                <div>
                                                    <el-select v-model="form.person" placeholder="请选择调研发起人">
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
                                            <div class="ddname">开始调研时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem1" type="datetime"
                                                    placeholder="开始调研时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                        <el-col :span="12">
                                            <div class="ddname">结束调研时间</div>
                                            <div class="block">
                                                <el-date-picker v-model="form.tiem2" type="datetime"
                                                    placeholder="结束调研时间">
                                                </el-date-picker>
                                            </div>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="12">
                                    <el-row :gutter="10">
                                        <el-col :span="12">
                                            <div class="ddname">项目类型</div>
                                            <el-select v-model="form.typename" placeholder="请选择项目类型">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>

                                        <el-col :span="12">
                                            <div class="ddname">状态</div>
                                            <el-select v-model="form.iszx" placeholder="请选择当前状态">
                                                <el-option v-for="item in typelist" :label="item.name"
                                                    :value="item.id"></el-option>
                                            </el-select>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>




                            <div>
                                <div class="pd10">
                                    <div class="ddname">调研说明</div>
                                    <div class="mark">调研说明的细节和内容</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入调研说明"></el-input>
                                </div>

                                <div class="pd10">
                                    <div class="ddname">调研目标</div>
                                    <div class="mark">调研目标的细节和内容</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入调研目标"></el-input>
                                </div>

                                <div class="pd10">
                                    <div class="ddname">调研内容</div>
                                    <div class="mark">调研目标的细节和内容</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入调研内容"></el-input>
                                </div>


                                <div class="pd10">
                                    <div class="ddname">市场需求分析</div>
                                    <div class="mark">市场需求分析描述</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入市场需求分析"></el-input>
                                </div>

                                <div class="pd10">
                                    <div class="ddname">竞争对手分析</div>
                                    <div class="mark">竞争对手分析的描述</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入竞争对手分析"></el-input>
                                </div>

                                <div class="pd10">
                                    <div class="ddname">调研结论</div>
                                    <div class="mark">调研结论的总结</div>
                                    <el-input v-model="form.target" type="textarea" :rows="5"
                                        placeholder="请输入调研结论"></el-input>
                                </div>
                            </div>

                            <el-row>
                                <el-col>
                                    <div class="ddname">附件上传</div>
                                    <div class="mark">上传附件信息</div>
                                    <el-upload class="upload-demo"
                                            action="https://jsonplaceholder.typicode.com/posts/"
                                            :on-preview="handlePreview" :on-remove="handleRemove"
                                            :before-remove="beforeRemove" multiple :limit="3" :on-exceed="handleExceed"
                                            :file-list="[]">
                                            <div class="filelist">
                                                <div class="file" v-for="item in fileList">
                                                    <div style="color: #2468f2;">{{ item.name }}</div>
                                                    <div style="color: #2468f2;justify-self: end;"
                                                        @click="toDetail(item.url)">
                                                        编辑</div>
                                                </div>
                                            </div>
                                            <el-button size="small" type="primary">点击上传</el-button>
                                            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                                        </el-upload>
                                </el-col>
                            </el-row>






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
                { name: '基哥项目调研报告', time: '20202-20-20 10-10', target: '11', content: '22', fenxi: '为什么需要', duishou: '对手什么操作', res: '66' }

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
            fileList: []

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
        toDetail(url) {
            window.open(url, '_blank')
        },
        toDetail() {
            this.$router.push('/project/researchDetail')
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

.file {
    display: grid;
    grid-template-columns: 1fr 1fr;
}
</style>