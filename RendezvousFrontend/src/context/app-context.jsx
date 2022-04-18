import { React, createContext } from "react";
import RendezvousService from "../repository/RendezvousRepository";

const AppContext = createContext({
  users: [],
  isLoggedIn: undefined,
});

export default AppContext;
