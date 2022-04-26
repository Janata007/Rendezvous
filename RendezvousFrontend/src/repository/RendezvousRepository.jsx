import axios from "../custom/axios";

const RendezvousService = {
  //users
  createUser: () => {
    return axios.post("/korisniciApi/users", "");
  },

  fetchAllUsers: () => {
    return axios.get("/korisniciApi/users");
  },

  fetchUserByUsername: (username) => {
    return axios.get(`/korisniciApi/users/username/${username}`);
  },

  //hobbies, sports, music genres, locations
  fetchAllHobbies: () => {
    return axios.get("/hobbiesApi/hobbies");
  },

  addHobbyToUser: (hobbyId, userId) => {
    return axios.put(`/korisniciApi/${userId}/hobbies/${hobbyId}`);
  },

  fetchAllSports: () => {
    return axios.get("/sportsApi/sports");
  },

  addSportToUser: (sportId, userId) => {
    return axios.put(`/korisniciApi/${userId}/sports/${sportId}`);
  },

  fetchAllMusicGenres: () => {
    return axios.get("/musicApi/genres");
  },

  addMusicGenreToUser: (musicGenreId, userId) => {
    return axios.put(`/korisniciApi/${userId}/music/${musicGenreId}`);
  },

  fetchAllLocations: () => {
    return axios.get("/locationsApi/locations");
  },

  addLocationToUser: (locationId, userId) => {
    return axios.put(`/korisniciApi/${userId}/locations/${locationId}`);
  },

  //match
  getMatchPercentForUsers: (userIdOne, userIdTwo) => {
    return axios.request({
      url: "matchApi/percent/",
      method: "get",
      params: {
        id1: userIdOne,
        id2: userIdTwo,
      },
    });
  },
};

export default RendezvousService;
