<template>
<div id="app">
  <section class="works">
    <div class="works__tilts">
      <div class="works__tilts_wrapper" v-for="(v, i) in blocks" :key="i">
      <div
           class="works__tilt tilt"
           @mouseenter="(e) => mouseEnter(e, i)"
           @mouseleave="mouseLeave"
           @mousemove="(e) => mouseMove(e, i)"
           :style="!isNone && i === index ? {
        '-webkit-transform': `rotateY(` + relativeOffsetX + `deg) rotateX(` + relativeOffsetY * -1 + `deg)`,
        '-moz-transform': `rotateY(` + relativeOffsetX + `deg) rotateX(` + relativeOffsetY * -1 + `deg)`,
        '-o-transform': `rotateY(` + relativeOffsetX + `deg) rotateX(` + relativeOffsetY * -1 + `deg)`,
        'transform': `rotateY(` + relativeOffsetX + `deg) rotateX(` + relativeOffsetY * -1 + `deg)`,
        'transition': `.2s ease-out`,
        'box-shadow': (-relativeOffsetX) +`px ` + (-relativeOffsetY) + `px 0 0 rgba(0,0,0,1)`
      } : {
        '-webkit-transform': `none`,
        '-moz-transform': `none`,
        '-o-transform': `none`,
        'transform': `none`,
        'transition': `.2s ease-out`,
        'box-shadow': `initial`
      }">
        <div class="tilt__img">
           <img :src="v.img" alt="img"> 
        </div>
       
        <h2 class="tilt__title">{{ v.title }}</h2>
        <p class="tilt__desc">
          {{ v.desc }}
        </p>
        <a @mouseenter="mouseLeave" @mouseleave="(e) => mouseEnter(e, i)" target="_blank"
           href="#" class="tilt__link">Link</a>
      </div>
    </div>
      </div>
  </section>
  </div>
</template>

<script>

export default {
  name: "VWorks",
  data() {
    return {
      blocks: [
        {
          img: "https://images.pexels.com/photos/17019640/pexels-photo-17019640/free-photo-of-man-people-woman-street.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
          title: 'Charly Verber',
          desc: 'Full-Stack developer'
        },
        {
          img: "https://images.pexels.com/photos/17045026/pexels-photo-17045026/free-photo-of-fashion-people-woman-relaxation.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
          title: 'Veona Stertly',
          desc: 'UX/UI Artist'
        }
      ],
      w: 0,
      h: 0,
      ratio: 0.25,
      index: null,
      absoluteOffsetX: 0,
      absoluteOffsetY: 0,
      relativeOffsetX: 0,
      relativeOffsetY: 0,
      isNone: true
    }
  },
  methods: {
    mouseEnter(e, i) {
      this.index = i
      this.isNone = false
      this.w = e.target.clientWidth
      this.h = e.target.clientHeight
    },
    mouseMove(e, i) {
      this.index = i
      this.absoluteOffsetX = e.offsetX - this.w / 2;
      this.absoluteOffsetY = e.offsetY - this.h / 2;
      this.relativeOffsetX = this.absoluteOffsetX * 100 / this.w * this.ratio;
      this.relativeOffsetY = this.absoluteOffsetY * 100 / this.h * this.ratio;
    },
    mouseLeave() {
      this.index = null
      this.isNone = true
    }
  }
}
</script>

<style scoped lang="scss">
  #app {
    background-color: #E8F6EF;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
 
  @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600&display=swap');
.works {
  font-family: 'Montserrat';
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 0 24px;
--primaryDarkestColor: #fefefe;
  --primaryDarkestColor: #000;
  &__title {
    padding-right: 16px;
    position: relative;

    &::after, &::before {
      content: '';
      position: absolute;
      right: 0;
      height: 2px;
      width: 2px;
      border: 1px solid var(--primaryDarkestColor);
    }

    &::after {
      top: 38%;
    }

    &::before {
      bottom: 23%;
    }
  }

  &__tilts {
    margin:-16px;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    &_wrapper {
      padding: 16px;
          .tilt {
        background-color: #fff;
      max-width: 245px;
      padding: 24px;
      height: 100%;
      min-height: 205px;
      max-width: 480px;
      border: 1px solid var(--primaryDarkestColor);
      border-radius: 16px;
      transform-style: preserve-3d;
      &__img {
        border-radius: 16px;
        height: 300px;
        width: 244px;
        overflow: hidden;
        img {
          width: 100%;
        }
      }
      &__title {
        display: flex;
        align-items: center;
          font-weight: 600;
  letter-spacing: 2px;
  font-size: 24px;
      }

      &__desc {
        font-size: 18px;
        font-weight: 500;
        margin-bottom: 16px;
      }

      &__link {
        font-size: 14px;
        // font-weignt: 500;
        text-decoration: none;
        color: #000;
        position: relative;
      }
    }
    }

  }
}
  }
</style>
