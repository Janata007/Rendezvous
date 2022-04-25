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
      return {
        ...state,
        isLoggedIn: false,
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
      };

    case "ADD_HOBBY":
      let hobbyToBePushed = { id: action.hobby.id, hobby: action.hobby.hobby };

      if (
        !state.activeUser.hobbies.some(
          (hobby) => hobby.hobby === hobbyToBePushed.hobby
        )
      )
        state.activeUser.hobbies.push(hobbyToBePushed);

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

    case "LOAD_USERS":
      action.users.forEach((user) => {
        if (user.username !== state.activeUser.username) state.users.push(user);
      });

      console.log(state.users);

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
