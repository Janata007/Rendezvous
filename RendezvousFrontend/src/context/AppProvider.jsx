import { React, useReducer } from "react";
import AppContext from "./app-context";

export const defaultAppState = {
  users: [],
  activeUser: {
    id: null,
    username: "",
    name: "",
    surname: "",
    email: "",
    city: "",
    hobbies: [],
    sports: [],
    musicGenres: [],
    locations: [],
  },
  isLoggedIn: false,
};

export const appReducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      return { ...state, isLoggedIn: true, activeUser: { ...action.user } };

    case "LOGOUT":
      return defaultAppState;

    case "ADD_HOBBY":
      let hobbyToBePushed = { id: action.hobby.id, hobby: action.hobby.hobby };

      if (
        !state.activeUser.hobbies.some(
          (hobby) => hobby.hobby === hobbyToBePushed.hobby
        )
      )
        state.activeUser.hobbies.push(hobbyToBePushed);

      return { ...state };

    case "REMOVED_HOBBY":
      let hobbyToBeRemoved = { id: action.hobby.id, hobby: action.hobby.hobby };

      let newUserHobbies = state.activeUser.hobbies.filter(
        (hobby) => hobby.id !== hobbyToBeRemoved.id
      );

      state.activeUser.hobbies = newUserHobbies;

      return { ...state };

    case "ADD_SPORT":
      let sportToBePushed = { id: action.sport.id, sport: action.sport.sport };

      if (
        !state.activeUser.sports.some(
          (sport) => sport.sport === sportToBePushed.sport
        )
      )
        state.activeUser.sports.push(sportToBePushed);

      return { ...state };

    case "REMOVED_SPORT":
      let sportToBeRemoved = { id: action.sport.id, sport: action.sport.sport };

      let newUserSports = state.activeUser.sports.filter(
        (sport) => sport.id !== sportToBeRemoved.id
      );

      state.activeUser.sports = newUserSports;

      return { ...state };

    case "ADD_MUSIC_GENRE":
      let musicGenreToBePushed = {
        id: action.musicGenre.id,
        musicGenre: action.musicGenre.musicGenre,
      };

      if (
        !state.activeUser.musicGenres.some(
          (musicGenre) =>
            musicGenre.musicGenre === musicGenreToBePushed.musicGenre
        )
      )
        state.activeUser.musicGenres.push(musicGenreToBePushed);

      return { ...state };

    case "REMOVED_MUSIC_GENRE":
      let musicGenreToBeRemoved = {
        id: action.musicGenre.id,
        musicGenre: action.musicGenre.musicGenre,
      };

      let newUserMusicGenres = state.activeUser.musicGenres.filter(
        (musicGenre) => musicGenre.id !== musicGenreToBeRemoved.id
      );

      state.activeUser.musicGenres = newUserMusicGenres;

      return { ...state };

    case "ADD_LOCATION":
      let locationToBePushed = {
        id: action.location.id,
        location: action.location.location,
      };

      if (
        !state.activeUser.locations.some(
          (location) => location.location === locationToBePushed.location
        )
      )
        state.activeUser.locations.push(locationToBePushed);

      return { ...state };

    case "REMOVED_LOCATION":
      let locationToBeRemoved = {
        id: action.location.id,
        location: action.location.location,
      };

      let newUserLocations = state.activeUser.locations.filter(
        (location) => location.id !== locationToBeRemoved.id
      );

      state.activeUser.locations = newUserLocations;

      return { ...state };

    case "LOAD_USERS":
      action.users.forEach((user) => {
        if (user.username !== state.activeUser.username) state.users.push(user);
      });
      console.log("in load users");

      return { ...state };

    default:
      return defaultAppState;
  }
};

const AppProvider = ({ children }) => {
  const [appState, dispatch] = useReducer(appReducer, defaultAppState);

  const appContext = {
    isLoggedIn: appState.isLoggedIn,
    activeUser: appState.activeUser,
    users: appState.users,
    dispatch: dispatch,
  };

  return (
    <AppContext.Provider value={appContext}>{children}</AppContext.Provider>
  );
};

export default AppProvider;
