import axios from "../custom/axios";

const RendezvousService = {
  //users
  createUser: (newUser) => {
    return axios.request({
      url: "korisniciApi/users",
      method: "post",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      data: newUser,
    });
  },

  fetchAllUsers: () => {
    return axios.get("/korisniciApi/users");
  },

  fetchAllUsersForLoggedInUser: (userId) => {
    return axios.get(`/korisniciApi/users/${userId}/search`);
  },

  fetchUserByUsername: (username) => {
    return axios.get(`/korisniciApi/users/username/${username}`);
  },

  fetchGeoLocation: () => {
    return axios.get("/korisniciApi/geoIP");
  },

  //hobbies, sports, music genres, locations
  fetchAllHobbies: () => {
    return axios.get("/hobbiesApi/hobbies");
  },

  addHobbyToUser: (hobbyId, userId) => {
    return axios.put(`/korisniciApi/${userId}/hobbies/${hobbyId}`);
  },

  removeHobbyFromUser: (hobbyId, userId) => {
    return axios.delete(`/korisniciApi/${userId}/hobbies/${hobbyId}`);
  },

  fetchAllSports: () => {
    return axios.get("/sportsApi/sports");
  },

  addSportToUser: (sportId, userId) => {
    return axios.put(`/korisniciApi/${userId}/sports/${sportId}`);
  },

  removeSportFromUser: (sportId, userId) => {
    return axios.delete(`/korisniciApi/${userId}/sports/${sportId}`);
  },

  fetchAllMusicGenres: () => {
    return axios.get("/musicApi/genres");
  },

  addMusicGenreToUser: (musicGenreId, userId) => {
    return axios.put(`/korisniciApi/${userId}/music/${musicGenreId}`);
  },

  removeMusicGenreFromUser: (musicGenreId, userId) => {
    return axios.delete(`/korisniciApi/${userId}/music/${musicGenreId}`);
  },

  fetchAllLocations: () => {
    return axios.get("/locationsApi/locations");
  },

  addLocationToUser: (locationId, userId) => {
    return axios.put(`/korisniciApi/${userId}/locations/${locationId}`);
  },

  removeLocationFromUser: (locationId, userId) => {
    return axios.delete(`/korisniciApi/${userId}/locations/${locationId}`);
  },

  //likes
  likeUser: (userId, likedUserId) => {
    return axios.post(`/likesApi/user/${userId}/likes/${likedUserId}`);
  },

  dislikeUser: (userId, dislikedUserId) => {
    return axios.post(`/likesApi/user/${userId}/dislikes/${dislikedUserId}`);
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

  areUsersMatched: (userIdOne, userIdTwo) => {
    return axios.request({
      url: "matchApi/match/",
      method: "get",
      params: {
        id1: userIdOne,
        id2: userIdTwo,
      },
    });
  },
};

export default RendezvousService;
