import { React, createContext } from "react";

const AppContext = createContext({
  users: [],
  username: undefined,
  isLoggedIn: undefined,
});

export default AppContext;
