import axios from "../custom/axios";

const RendezvousService = {
  fetchUsers: () => {
    return axios.get("/korisniciApi/users");
  },

  fetchUserByUsername: (username) => {
    return axios.get(`/korisniciApi/users/username/${username}`);
  },

  createUser: () => {
    return axios.post("/korisniciApi/users", "");
  },
};

export default RendezvousService;
