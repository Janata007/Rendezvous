import { React, useReducer } from "react";
import AppContext from "./app-context";

export const defaultAppState = {
  isLoggedIn: false,
};

export const appReducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      return { ...state, isLoggedIn: true };
    case "LOGOFF":
      return { ...state, isLoggedIn: false };
    default:
      return defaultAppState;
  }
};

const AppProvider = ({ children }) => {
  const [appState, dispatch] = useReducer(appReducer, defaultAppState);

  const appContext = {
    isLoggedIn: appState.isLoggedIn,
    dispatch: dispatch,
  };

  return (
    <AppContext.Provider value={appContext}>{children}</AppContext.Provider>
  );
};

export default AppProvider;