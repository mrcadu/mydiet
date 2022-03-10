<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="food">
        <h2 class="jh-entity-heading" data-cy="foodDetailsHeading">
          <span v-text="$t('dietApp.food.detail.title')">Food</span> {{ food.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('dietApp.food.name')">Name</span>
          </dt>
          <dd>
            <span>{{ food.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.grams')">Grams</span>
          </dt>
          <dd>
            <span>{{ food.grams }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.protein')">Protein</span>
          </dt>
          <dd>
            <span>{{ food.protein }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.carbohydrate')">Carbohydrate</span>
          </dt>
          <dd>
            <span>{{ food.carbohydrate }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.fat')">Fat</span>
          </dt>
          <dd>
            <span>{{ food.fat }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.calories')">Calories</span>
          </dt>
          <dd>
            <span>{{ food.calories }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.username')">Username</span>
          </dt>
          <dd>
            <span>{{ food.username }}</span>
          </dd>
          <dt>
            <span v-text="$t('dietApp.food.meal')">Meal</span>
          </dt>
          <dd>
            <div v-if="food.meal">
              <router-link :to="{ name: 'MealView', params: { mealId: food.meal.id } }">{{ food.meal.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./food-details.component.ts"></script>
