<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="addFoodDataProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="addFoodDataProcessDetailsHeading">
          <span v-text="$t('dietApp.addFoodDataProcess.detail.title')">AddFoodDataProcess</span> {{ addFoodDataProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="addFoodDataProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('dietApp.addFoodDataProcess.detail.title')">AddFoodDataProcess</span> #{{ addFoodDataProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="addFoodDataProcess.food">
              <h5 class="card-header">
                <span class="title"> Food #{{ addFoodDataProcess.food.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="food-name"
                    data-cy="name"
                    v-model="addFoodDataProcess.food.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.username')">username</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="username"
                    id="food-username"
                    data-cy="username"
                    v-model="addFoodDataProcess.food.username"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.grams')">grams</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="grams"
                    id="food-grams"
                    data-cy="grams"
                    v-model="addFoodDataProcess.food.grams"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.protein')">protein</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="protein"
                    id="food-protein"
                    data-cy="protein"
                    v-model="addFoodDataProcess.food.protein"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.carbohydrate')">carbohydrate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="carbohydrate"
                    id="food-carbohydrate"
                    data-cy="carbohydrate"
                    v-model="addFoodDataProcess.food.carbohydrate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.fat')">fat</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="fat"
                    id="food-fat"
                    data-cy="fat"
                    v-model="addFoodDataProcess.food.fat"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.addFoodDataProcess.calories')">calories</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="calories"
                    id="food-calories"
                    data-cy="calories"
                    v-model="addFoodDataProcess.food.calories"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./add-food-data-process-details.component.ts"></script>
