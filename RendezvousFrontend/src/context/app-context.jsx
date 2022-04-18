import { React, createContext } from "react";

const AppContext = createContext({
  users: [],
  isLoggedIn: undefined,
});

export default AppContext;
