<template>
  <div>
    <h2 id="page-heading" data-cy="UserDietHeading">
      <span v-text="$t('dietApp.userDiet.home.title')" id="user-diet-heading">User Diets</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('dietApp.userDiet.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && userDiets && userDiets.length === 0">
      <span v-text="$t('dietApp.userDiet.home.notFound')">No userDiets found</span>
    </div>
    <div class="table-responsive" v-if="userDiets && userDiets.length > 0">
      <table class="table table-striped" aria-describedby="userDiets">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.username')">Username</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.password')">Password</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.age')">Age</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.genre')">Genre</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.biotype')">Biotype</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.goal')">Goal</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.weight')">Weight</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.height')">Height</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.neck')">Neck</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.waist')">Waist</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.hip')">Hip</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.bodyFat')">Body Fat</span></th>
            <th scope="row"><span v-text="$t('dietApp.userDiet.diet')">Diet</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="userDiet in userDiets" :key="userDiet.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'UserDietView', params: { userDietId: userDiet.id } }">{{ userDiet.id }}</router-link>
            </td>
            <td>{{ userDiet.username }}</td>
            <td>{{ userDiet.password }}</td>
            <td>{{ userDiet.age }}</td>
            <td>{{ userDiet.genre }}</td>
            <td>{{ userDiet.biotype }}</td>
            <td>{{ userDiet.goal }}</td>
            <td>{{ userDiet.weight }}</td>
            <td>{{ userDiet.height }}</td>
            <td>{{ userDiet.neck }}</td>
            <td>{{ userDiet.waist }}</td>
            <td>{{ userDiet.hip }}</td>
            <td>{{ userDiet.bodyFat }}</td>
            <td>
              <div v-if="userDiet.diet">
                <router-link :to="{ name: 'DietView', params: { dietId: userDiet.diet.id } }">{{ userDiet.diet.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'UserDietView', params: { userDietId: userDiet.id } }" custom v-slot="{ navigate }">
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
        ><span id="dietApp.userDiet.delete.question" data-cy="userDietDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-userDiet-heading" v-text="$t('dietApp.userDiet.delete.question', { id: removeId })">
          Are you sure you want to delete this User Diet?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-userDiet"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeUserDiet()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./user-diet.component.ts"></script>
