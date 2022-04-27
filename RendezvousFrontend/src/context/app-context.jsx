import { createContext } from "react";

const AppContext = createContext({
  isLoggedIn: false,
  activeUser: {},
  users: [],
  likedUsers: [],
  dislikedUsers: [],
});

export default AppContext;
