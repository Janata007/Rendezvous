import { createContext } from "react";

const AppContext = createContext({
  isLoggedIn: false,
  activeUser: {},
  users: [],
});

export default AppContext;
