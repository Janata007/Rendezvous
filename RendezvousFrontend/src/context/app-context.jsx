import { React, createContext } from "react";

const AppContext = createContext({
  isLoggedIn: undefined,
  activeUser: {},
  users: [],
});

export default AppContext;
