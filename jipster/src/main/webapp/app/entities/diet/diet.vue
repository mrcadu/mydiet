<template>
  <div>
    <h2 id="page-heading" data-cy="DietHeading">
      <span id="diet-heading">Diets</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && diets && diets.length === 0">
      <span>No diets found</span>
    </div>
    <div class="table-responsive" v-if="diets && diets.length > 0">
      <table class="table table-striped" aria-describedby="diets">
        <thead>
          <tr>
            <th scope="row"><span>ID</span></th>
            <th scope="row"><span>Basal Metabolic Rate</span></th>
            <th scope="row"><span>Calories Goal</span></th>
            <th scope="row"><span>Protein</span></th>
            <th scope="row"><span>Carbohydrate</span></th>
            <th scope="row"><span>Fat</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="diet in diets" :key="diet.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'DietView', params: { dietId: diet.id } }">{{ diet.id }}</router-link>
            </td>
            <td>{{ diet.basalMetabolicRate }}</td>
            <td>{{ diet.caloriesGoal }}</td>
            <td>{{ diet.protein }}</td>
            <td>{{ diet.carbohydrate }}</td>
            <td>{{ diet.fat }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'DietView', params: { dietId: diet.id } }" custom v-slot="{ navigate }">
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
        ><span id="jipsterApp.diet.delete.question" data-cy="dietDeleteDialogHeading">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-diet-heading">Are you sure you want to delete this Diet?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-diet"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removeDiet()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./diet.component.ts"></script>
