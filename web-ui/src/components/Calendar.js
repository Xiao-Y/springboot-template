import VueCalendarComponent from 'vue-calendar-component';

const Calendar = {
    install: function (Vue) {
        Vue.component('Calendar', VueCalendarComponent)
    }
}

export default Calendar;