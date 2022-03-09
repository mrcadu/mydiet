<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="dietApp.storeUserDataStartForm.home.createOrEditLabel"
          data-cy="StoreUserDataStartFormCreateUpdateHeading"
          v-text="$t('dietApp.storeUserDataStartForm.home.createOrEditLabel')"
        >
          Create or edit a StoreUserDataStartForm
        </h2>
        <div v-if="storeUserDataProcess.processInstance">
          <akip-show-process-definition :processDefinition="storeUserDataProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="storeUserDataProcess.userDiet">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.username')"
                    for="store-user-data-start-form-username"
                    >Username</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="username"
                    id="store-user-data-start-form-username"
                    data-cy="username"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.username.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.username.$invalid,
                    }"
                    v-model="$v.storeUserDataProcess.userDiet.username.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.password')"
                    for="store-user-data-start-form-password"
                    >Password</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="password"
                    id="store-user-data-start-form-password"
                    data-cy="password"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.password.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.password.$invalid,
                    }"
                    v-model="$v.storeUserDataProcess.userDiet.password.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.storeUserDataStartForm.age')" for="store-user-data-start-form-age"
                    >Age</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="age"
                    id="store-user-data-start-form-age"
                    data-cy="age"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.age.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.age.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.age.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.genre')"
                    for="store-user-data-start-form-genre"
                    >Genre</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="genre"
                    id="store-user-data-start-form-genre"
                    data-cy="genre"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.genre.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.genre.$invalid,
                    }"
                    v-model="$v.storeUserDataProcess.userDiet.genre.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.biotype')"
                    for="store-user-data-start-form-biotype"
                    >Biotype</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="biotype"
                    id="store-user-data-start-form-biotype"
                    data-cy="biotype"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.biotype.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.biotype.$invalid,
                    }"
                    v-model="$v.storeUserDataProcess.userDiet.biotype.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.storeUserDataStartForm.goal')" for="store-user-data-start-form-goal"
                    >Goal</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="goal"
                    id="store-user-data-start-form-goal"
                    data-cy="goal"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.goal.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.goal.$invalid,
                    }"
                    v-model="$v.storeUserDataProcess.userDiet.goal.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.weight')"
                    for="store-user-data-start-form-weight"
                    >Weight</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="weight"
                    id="store-user-data-start-form-weight"
                    data-cy="weight"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.weight.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.weight.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.weight.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.height')"
                    for="store-user-data-start-form-height"
                    >Height</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="height"
                    id="store-user-data-start-form-height"
                    data-cy="height"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.height.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.height.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.height.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.storeUserDataStartForm.neck')" for="store-user-data-start-form-neck"
                    >Neck</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="neck"
                    id="store-user-data-start-form-neck"
                    data-cy="neck"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.neck.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.neck.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.neck.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.waist')"
                    for="store-user-data-start-form-waist"
                    >Waist</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="waist"
                    id="store-user-data-start-form-waist"
                    data-cy="waist"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.waist.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.waist.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.waist.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('dietApp.storeUserDataStartForm.hip')" for="store-user-data-start-form-hip"
                    >Hip</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="hip"
                    id="store-user-data-start-form-hip"
                    data-cy="hip"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.hip.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.hip.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.hip.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('dietApp.storeUserDataStartForm.bodyFat')"
                    for="store-user-data-start-form-bodyFat"
                    >Body Fat</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="bodyFat"
                    id="store-user-data-start-form-bodyFat"
                    data-cy="bodyFat"
                    :class="{
                      valid: !$v.storeUserDataProcess.userDiet.bodyFat.$invalid,
                      invalid: $v.storeUserDataProcess.userDiet.bodyFat.$invalid,
                    }"
                    v-model.number="$v.storeUserDataProcess.userDiet.bodyFat.$model"
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
            :disabled="$v.storeUserDataProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./store-user-data-start-form-init.component.ts"></script>
