<script>
import apiClient from '@/api/axios.js';

export default {
  props: { user: Object },
  mounted() {
    console.log("User w UserCard.vue:", this.user); 
  },
  methods: {
    deleteUser() {
      if (!this.user || !this.user.id) {
        console.error("Błąd: ID użytkownika jest undefined!", this.user);
        return;
      }
      apiClient.delete(`/users/${this.user.id}`)
        .then(() => {
          alert('Użytkownik usunięty!');
          this.$emit('userDeleted', this.user.id); 
        })
        .catch(error => {
          console.error('Błąd usuwania użytkownika:', error);
        });
    }
  }
};
</script>
