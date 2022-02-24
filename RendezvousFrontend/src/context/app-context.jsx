import { React, createContext } from "react";

const AppContext = createContext({
  isLoggedIn: undefined,
});

export default AppContext;
