<template>
  <div>
    <h2 id="page-heading" data-cy="MealHeading">
      <span v-text="$t('dietApp.meal.home.title')" id="meal-heading">Meals</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('dietApp.meal.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && meals && meals.length === 0">
      <span v-text="$t('dietApp.meal.home.notFound')">No meals found</span>
    </div>
    <div class="table-responsive" v-if="meals && meals.length > 0">
      <table class="table table-striped" aria-describedby="meals">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('dietApp.meal.name')">Name</span></th>
            <th scope="row"><span v-text="$t('dietApp.meal.diet')">Diet</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="meal in meals" :key="meal.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MealView', params: { mealId: meal.id } }">{{ meal.id }}</router-link>
            </td>
            <td>{{ meal.name }}</td>
            <td>
              <div v-if="meal.diet">
                <router-link :to="{ name: 'DietView', params: { dietId: meal.diet.id } }">{{ meal.diet.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MealView', params: { mealId: meal.id } }" custom v-slot="{ navigate }">
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
        ><span id="dietApp.meal.delete.question" data-cy="mealDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-meal-heading" v-text="$t('dietApp.meal.delete.question', { id: removeId })">
          Are you sure you want to delete this Meal?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-meal"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMeal()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./meal.component.ts"></script>
