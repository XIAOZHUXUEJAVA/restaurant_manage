<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="foodName">
        <el-input
          v-model="queryParams.foodName"
          placeholder="请输入名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评分" prop="foodStar">
        <el-input
          v-model="queryParams.foodStar"
          placeholder="请输入评分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销量" prop="foodVote">
        <el-input
          v-model="queryParams.foodVote"
          placeholder="请输入销量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="foodPrice">
        <el-input
          v-model="queryParams.foodPrice"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="折扣" prop="foodDiscount">
        <el-input
          v-model="queryParams.foodDiscount"
          placeholder="请输入折扣"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="份量" prop="foodDesc">
        <el-input
          v-model="queryParams.foodDesc"
          placeholder="请输入份量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="foodStatus">
        <el-input
          v-model="queryParams.foodStatus"
          placeholder="请输入状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="类型" prop="foodType">
        <el-input
          v-model="queryParams.foodType"
          placeholder="请输入类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="种类" prop="foodCategory">
        <el-input
          v-model="queryParams.foodCategory"
          placeholder="请输入种类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['food:food:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['food:food:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['food:food:remove']"
        >删除</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['food:food:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="foodList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="foodId" />
      <el-table-column label="名称" align="center" prop="foodName" />
      <el-table-column label="评分" align="center" prop="foodStar" />
      <el-table-column label="销量" align="center" prop="foodVote" />
      <el-table-column label="价格" align="center" prop="foodPrice" />
      <el-table-column label="折扣" align="center" prop="foodDiscount" />
      <el-table-column label="份量" align="center" prop="foodDesc" />
      <el-table-column label="状态" align="center" prop="foodStatus" />
      <el-table-column label="类型" align="center" prop="foodType" />
      <el-table-column label="种类" align="center" prop="foodCategory" />
      <el-table-column label="参考图" align="center" prop="foodSrc" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.foodSrc" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['food:food:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['food:food:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改菜品管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="foodName">
          <el-input v-model="form.foodName" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="评分" prop="foodStar">
          <el-input v-model="form.foodStar" placeholder="请输入评分" />
        </el-form-item>
        <el-form-item label="销量" prop="foodVote">
          <el-input v-model="form.foodVote" placeholder="请输入销量" />
        </el-form-item>
        <el-form-item label="价格" prop="foodPrice">
          <el-input v-model="form.foodPrice" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="折扣" prop="foodDiscount">
          <el-input v-model="form.foodDiscount" placeholder="请输入折扣" />
        </el-form-item>
        <el-form-item label="份量" prop="foodDesc">
          <el-input v-model="form.foodDesc" placeholder="请输入份量" />
        </el-form-item>
        <el-form-item label="状态" prop="foodStatus">
          <el-select v-model="form.foodStatus" >
            <el-option label="请选择" value=""></el-option>
            <el-option label="热销" value="best seller"></el-option>
            <el-option label="普通" value="normal"></el-option>
<!--            <el-option v-for="item in status" :key="item.id" :label="item.name" :value="item.id">-->
<!--            </el-option>-->
          </el-select>
        </el-form-item>


        <el-form-item label="类型" prop="foodType">
          <el-select v-model="form.foodType" >
            <el-option label="请选择" value=""></el-option>
            <el-option label="肉类" value="meat"></el-option>
            <el-option label="素类" value="vegan"></el-option>
            <!--            <el-option v-for="item in status" :key="item.id" :label="item.name" :value="item.id">-->
            <!--            </el-option>-->
          </el-select>
        </el-form-item>


        <el-form-item label="种类" prop="foodCategory">
          <el-select v-model="form.foodCategory" >
            <el-option label="请选择" value=""></el-option>
            <el-option label="塔克" value="taco"></el-option>
            <el-option label="小吃" value="sides"></el-option>
            <!--            <el-option v-for="item in status" :key="item.id" :label="item.name" :value="item.id">-->
            <!--            </el-option>-->
          </el-select>
        </el-form-item>

        <el-form-item label="参考图">
          <image-upload v-model="form.foodSrc"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFood, getFood, delFood, addFood, updateFood } from "@/api/food/food";

export default {
  name: "Food",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 菜品管理表格数据
      foodList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // status: ['best_seller', 'normal', 'new dishes'],
      status: [{
        id: 1,
        name: 'best_seller'
      },
        {
          id: 2,
          name: 'normal'
        }],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        foodName: null,
        foodStar: null,
        foodVote: null,
        foodPrice: null,
        foodDiscount: null,
        foodDesc: null,
        foodStatus: null,
        foodType: null,
        foodCategory: null,
        foodSrc: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        foodName: [
          { required: true, message: "名称不能为空", trigger: "blur" }
        ],
        foodStar: [
          { required: true, message: "评分不能为空", trigger: "blur" }
        ],
        foodVote: [
          { required: true, message: "销量不能为空", trigger: "blur" }
        ],
        foodPrice: [
          { required: true, message: "价格不能为空", trigger: "blur" }
        ],
        foodDiscount: [
          { required: true, message: "折扣不能为空", trigger: "blur" }
        ],
        foodDesc: [
          { required: true, message: "份量不能为空", trigger: "blur" }
        ],
        foodStatus: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
        foodType: [
          { required: true, message: "类型不能为空", trigger: "change" }
        ],
        foodCategory: [
          { required: true, message: "种类不能为空", trigger: "change" }
        ],
        foodSrc: [
          { required: true, message: "参考图不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询菜品管理列表 */
    getList() {
      this.loading = true;
      listFood(this.queryParams).then(response => {
        this.foodList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        foodId: null,
        foodName: null,
        foodStar: null,
        foodVote: null,
        foodPrice: null,
        foodDiscount: null,
        foodDesc: null,
        foodStatus: "0",
        foodType: null,
        foodCategory: null,
        foodSrc: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.foodId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加菜品管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const foodId = row.foodId || this.ids
      getFood(foodId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改菜品管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.foodId != null) {
            updateFood(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFood(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const foodIds = row.foodId || this.ids;
      this.$modal.confirm('是否确认删除菜品管理编号为"' + foodIds + '"的数据项？').then(function() {
        return delFood(foodIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('food/food/export', {
        ...this.queryParams
      }, `food_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
