import { React, useReducer } from "react";
import AppContext from "./app-context";

export const defaultAppState = {
  users: [],
  activeUser: {
    username: "",
    name: "",
    surname: "",
    email: "",
    city: "",
    hobbies: [],
    sports: [],
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
          username: "",
          name: "",
          surname: "",
          email: "",
          city: "",
          hobbies: [],
          sports: [],
        },
      };
    case "LOAD_USERS":
      return { ...state, users: action.users };
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
