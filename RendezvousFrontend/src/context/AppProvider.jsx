import { React, useReducer } from "react";
import AppContext from "./app-context";

export const defaultAppState = {
  users: [],
  likedUsers: [],
  dislikedUsers: [],
  matchedUsers: [],
  activeUser: {
    id: null,
    username: "",
    name: "",
    surname: "",
    email: "",
    city: "",
    authority: "",
    hobbies: [],
    sports: [],
    musicGenres: [],
    locations: [],
  },
  isLoggedIn: false,
};

export const appReducer = (state, action) => {
  const addEnum = (id, value, enumType, enumArray) => {
    let enumToBePushed = { id: id };
    enumToBePushed[enumType] = value;

    if (
      !state.activeUser[enumArray].some(
        (el) => el[enumType] === enumToBePushed[enumType]
      )
    )
      state.activeUser[enumArray].push(enumToBePushed);
  };

  const removeEnum = (id, enumArray) => {
    let enumToBeRemoved = { id: id };

    let newUserHobbies = state.activeUser[enumArray].filter(
      (el) => el.id !== enumToBeRemoved.id
    );

    state.activeUser[enumArray] = newUserHobbies;
  };

  switch (action.type) {
    //AUTH
    case "LOGIN":
      return {
        ...state,
        isLoggedIn: true,
        activeUser: { ...action.user },
        matchedUsers: [],
      };

    case "LOGOUT":
      return defaultAppState;

    case "ADD_GEOLOCATION":
      let location;
      action.geoLocation === "UNKNOWN"
        ? (location = "This location is unsupported at the moment")
        : (location = action.geoLocation);

      state.activeUser.geoLocation = location;

      return { ...state };

    //ENUMS
    case "ADD_HOBBY":
      addEnum(action.hobby.id, action.hobby.hobby, "hobby", "hobbies");

      return { ...state };

    case "REMOVED_HOBBY":
      removeEnum(action.hobby.id, "hobbies");

      return { ...state };

    case "ADD_SPORT":
      addEnum(action.sport.id, action.sport.sport, "sport", "sports");

      return { ...state };

    case "REMOVED_SPORT":
      removeEnum(action.sport.id, "sports");

      return { ...state };

    case "ADD_MUSIC_GENRE":
      addEnum(
        action.musicGenre.id,
        action.musicGenre.musicGenre,
        "musicGenre",
        "musicGenres"
      );

      return { ...state };

    case "REMOVED_MUSIC_GENRE":
      removeEnum(action.musicGenre.id, "musicGenres");

      return { ...state };

    case "ADD_LOCATION":
      addEnum(
        action.location.id,
        action.location.location,
        "location",
        "locations"
      );

      return { ...state };

    case "REMOVED_LOCATION":
      removeEnum(action.location.id, "locations");

      return { ...state };

    //EVENTS
    case "LOAD_USERS":
      state.users = action.users.filter(
        (user) => user.id !== state.activeUser.id
      );

      return { ...state };

    case "SKIPPED_USER":
      let userToBeSkipped = action.user;
      let usersPresent = state.users;

      usersPresent.push(
        usersPresent.splice(usersPresent.indexOf(userToBeSkipped), 1)[0]
      );

      return { ...state, users: usersPresent };

    case "LIKED_USER":
      let newlyLikedUser = action.likedUser;
      let likedUsers = state.likedUsers;

      likedUsers.push(newlyLikedUser);
      state.users.shift();

      return { ...state, likedUsers: likedUsers };

    case "DISLIKED_USER":
      let newlyDislikedUser = action.dislikedUser;
      let dislikedUsers = state.dislikedUsers;

      dislikedUsers.push(newlyDislikedUser);
      state.users.shift();

      return { ...state, dislikedUsers: dislikedUsers };

    case "MATCHED_USER":
      console.log("match event");
      let newlyMatchedUser = action.matchedUser;
      let matchedUsers = state.matchedUsers;

      matchedUsers.push(newlyMatchedUser);

      return { ...state, matchedUsers: matchedUsers };
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
    likedUsers: appState.likedUsers,
    dislikedUsers: appState.dislikedUsers,
    matchedUsers: appState.matchedUsers,

    dispatch: dispatch,
  };

  return (
    <AppContext.Provider value={appContext}>{children}</AppContext.Provider>
  );
};

export default AppProvider;
