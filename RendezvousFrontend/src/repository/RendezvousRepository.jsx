import axios from "../custom/axios";

const RendezvousService = {
  fetchUsers: () => {
    return axios.get("/korisniciApi/users");
  },

  createUser: () => {
    return axios.post("/korisniciApi/users", "");
  },
};

export default RendezvousService;
