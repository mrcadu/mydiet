<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="userDiet">
        <h2 class="jh-entity-heading" data-cy="userDietDetailsHeading"><span>UserDiet</span> {{ userDiet.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Username</span>
          </dt>
          <dd>
            <span>{{ userDiet.username }}</span>
          </dd>
          <dt>
            <span>Password</span>
          </dt>
          <dd>
            <span>{{ userDiet.password }}</span>
          </dd>
          <dt>
            <span>Age</span>
          </dt>
          <dd>
            <span>{{ userDiet.age }}</span>
          </dd>
          <dt>
            <span>Genre</span>
          </dt>
          <dd>
            <span>{{ userDiet.genre }}</span>
          </dd>
          <dt>
            <span>Biotype</span>
          </dt>
          <dd>
            <span>{{ userDiet.biotype }}</span>
          </dd>
          <dt>
            <span>Goal</span>
          </dt>
          <dd>
            <span>{{ userDiet.goal }}</span>
          </dd>
          <dt>
            <span>Weight</span>
          </dt>
          <dd>
            <span>{{ userDiet.weight }}</span>
          </dd>
          <dt>
            <span>Height</span>
          </dt>
          <dd>
            <span>{{ userDiet.height }}</span>
          </dd>
          <dt>
            <span>Neck</span>
          </dt>
          <dd>
            <span>{{ userDiet.neck }}</span>
          </dd>
          <dt>
            <span>Waist</span>
          </dt>
          <dd>
            <span>{{ userDiet.waist }}</span>
          </dd>
          <dt>
            <span>Hip</span>
          </dt>
          <dd>
            <span>{{ userDiet.hip }}</span>
          </dd>
          <dt>
            <span>Body Fat</span>
          </dt>
          <dd>
            <span>{{ userDiet.bodyFat }}</span>
          </dd>
          <dt>
            <span>Diet</span>
          </dt>
          <dd>
            <div v-if="userDiet.diet">
              <router-link :to="{ name: 'DietView', params: { dietId: userDiet.diet.id } }">{{ userDiet.diet.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./user-diet-details.component.ts"></script>
