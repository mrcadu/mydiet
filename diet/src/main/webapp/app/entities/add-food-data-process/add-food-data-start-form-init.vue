<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="dietApp.addFoodDataStartForm.home.createOrEditLabel"
          data-cy="AddFoodDataStartFormCreateUpdateHeading"
          v-text="$t('dietApp.addFoodDataStartForm.home.createOrEditLabel')"
        >
          Create or edit a AddFoodDataStartForm
        </h2>
        <div v-if="addFoodDataProcess.processInstance">
          <akip-show-process-definition :processDefinition="addFoodDataProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="addFoodDataProcess.food">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataStartForm.name')" for="add-food-data-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="add-food-data-start-form-name"
                    data-cy="name"
                    :class="{ valid: !$v.addFoodDataProcess.food.name.$invalid, invalid: $v.addFoodDataProcess.food.name.$invalid }"
                    v-model="$v.addFoodDataProcess.food.name.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataStartForm.grams')" for="add-food-data-start-form-grams"
                    >Grams</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="grams"
                    id="add-food-data-start-form-grams"
                    data-cy="grams"
                    :class="{ valid: !$v.addFoodDataProcess.food.grams.$invalid, invalid: $v.addFoodDataProcess.food.grams.$invalid }"
                    v-model.number="$v.addFoodDataProcess.food.grams.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.addFoodDataStartForm.protein')"
                    for="add-food-data-start-form-protein"
                    >Protein</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="protein"
                    id="add-food-data-start-form-protein"
                    data-cy="protein"
                    :class="{ valid: !$v.addFoodDataProcess.food.protein.$invalid, invalid: $v.addFoodDataProcess.food.protein.$invalid }"
                    v-model.number="$v.addFoodDataProcess.food.protein.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.addFoodDataStartForm.carbohydrate')"
                    for="add-food-data-start-form-carbohydrate"
                    >Carbohydrate</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="carbohydrate"
                    id="add-food-data-start-form-carbohydrate"
                    data-cy="carbohydrate"
                    :class="{
                      valid: !$v.addFoodDataProcess.food.carbohydrate.$invalid,
                      invalid: $v.addFoodDataProcess.food.carbohydrate.$invalid,
                    }"
                    v-model.number="$v.addFoodDataProcess.food.carbohydrate.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataStartForm.fat')" for="add-food-data-start-form-fat"
                    >Fat</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="fat"
                    id="add-food-data-start-form-fat"
                    data-cy="fat"
                    :class="{ valid: !$v.addFoodDataProcess.food.fat.$invalid, invalid: $v.addFoodDataProcess.food.fat.$invalid }"
                    v-model.number="$v.addFoodDataProcess.food.fat.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.addFoodDataStartForm.calories')"
                    for="add-food-data-start-form-calories"
                    >Calories</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="calories"
                    id="add-food-data-start-form-calories"
                    data-cy="calories"
                    :class="{ valid: !$v.addFoodDataProcess.food.calories.$invalid, invalid: $v.addFoodDataProcess.food.calories.$invalid }"
                    v-model.number="$v.addFoodDataProcess.food.calories.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.addFoodDataProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./add-food-data-start-form-init.component.ts"></script>
