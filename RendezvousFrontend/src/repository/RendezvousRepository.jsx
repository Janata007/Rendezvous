import axios from '../custom/axios'

const RendezvousService = {
    fetchUsers: () => {
        return axios.get("/users")
    },

    createUser: () => {
        return axios.post("/users", "");
    }
}

export default RendezvousService;