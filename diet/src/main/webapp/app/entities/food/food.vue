<template>
  <div>
    <h2 id="page-heading" data-cy="FoodHeading">
      <span v-text="$t('dietApp.food.home.title')" id="food-heading">Foods</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('dietApp.food.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && foods && foods.length === 0">
      <span v-text="$t('dietApp.food.home.notFound')">No foods found</span>
    </div>
    <div class="table-responsive" v-if="foods && foods.length > 0">
      <table class="table table-striped" aria-describedby="foods">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.name')">Name</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.grams')">Grams</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.protein')">Protein</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.carbohydrate')">Carbohydrate</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.fat')">Fat</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.calories')">Calories</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.username')">Username</span></th>
            <th scope="row"><span v-text="$t('dietApp.food.meal')">Meal</span></th>
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
            <td>{{ food.username }}</td>
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
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
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
        ><span id="dietApp.food.delete.question" data-cy="foodDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-food-heading" v-text="$t('dietApp.food.delete.question', { id: removeId })">
          Are you sure you want to delete this Food?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-food"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFood()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./food.component.ts"></script>
