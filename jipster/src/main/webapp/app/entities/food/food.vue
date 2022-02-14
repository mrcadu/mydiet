<template>
  <div>
    <h2 id="page-heading" data-cy="FoodHeading">
      <span id="food-heading">Foods</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && foods && foods.length === 0">
      <span>No foods found</span>
    </div>
    <div class="table-responsive" v-if="foods && foods.length > 0">
      <table class="table table-striped" aria-describedby="foods">
        <thead>
          <tr>
            <th scope="row"><span>ID</span></th>
            <th scope="row"><span>Name</span></th>
            <th scope="row"><span>Grams</span></th>
            <th scope="row"><span>Protein</span></th>
            <th scope="row"><span>Carbohydrate</span></th>
            <th scope="row"><span>Fat</span></th>
            <th scope="row"><span>Calories</span></th>
            <th scope="row"><span>Meal</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="food in foods" :key="food.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FoodView', params: { foodId: food.id } }">{{ food.id }}</router-link>
            </td>
            <td>{{ food.name }}</td>
            <td>{{ food.grams }}</td>
            <td>{{ food.protein }}</td>
            <td>{{ food.carbohydrate }}</td>
            <td>{{ food.fat }}</td>
            <td>{{ food.calories }}</td>
            <td>
              <div v-if="food.meal">
                <router-link :to="{ name: 'MealView', params: { mealId: food.meal.id } }">{{ food.meal.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'FoodView', params: { foodId: food.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="jipsterApp.food.delete.question" data-cy="foodDeleteDialogHeading">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-food-heading">Are you sure you want to delete this Food?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-food"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removeFood()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./food.component.ts"></script>
