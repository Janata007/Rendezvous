import React, { useContext, useEffect, useState } from "react";
import AppProvider from "./context/AppProvider";
import Container from "./components/Layout/Container/Container";

const App = () => {
  return (
    <AppProvider>
      <Container />
    </AppProvider>
  );
};

export default App;
