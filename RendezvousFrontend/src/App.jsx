import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import AppProvider from "./context/AppProvider";
import Container from "./components/Layout/Container/Container";

const App = () => {
  return (
    <Router>
      <AppProvider>
        <Container />
      </AppProvider>
    </Router>
  );
};

export default App;
