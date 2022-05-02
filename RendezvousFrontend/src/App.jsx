import { React, useContext } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AppProvider from "./context/AppProvider";
import Home from "./pages/Home/Home";
import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";
import NotFound from "./pages/Misc/NotFound";
import EditHobbies from "./pages/Profile/EditHobbies";
import EditLocations from "./pages/Profile/EditLocations";
import EditMusicGenres from "./pages/Profile/EditMusicGenres";
import EditSports from "./pages/Profile/EditSports";
import Profile from "./pages/Profile/Profile";
import Matches from "./pages/Profile/Matches";
import AppContext from "./context/app-context";
import Forbidden from "./pages/Misc/Forbidden";

const App = () => {
  const appContext = useContext(AppContext);

  return (
    <AppProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route
            path="/profile"
            element={appContext.isLoggedIn ? <Profile /> : <Forbidden />}
          />

          <Route
            path="/profile/editHobbies"
            element={appContext.isLoggedIn ? <EditHobbies /> : <Forbidden />}
          />
          <Route
            path="/profile/editSports"
            element={appContext.isLoggedIn ? <EditSports /> : <Forbidden />}
          />
          <Route
            path="/profile/editMusicGenres"
            element={
              appContext.isLoggedIn ? <EditMusicGenres /> : <Forbidden />
            }
          />
          <Route
            path="/profile/editLocations"
            element={appContext.isLoggedIn ? <EditLocations /> : <Forbidden />}
          />
          <Route
            path="/matches"
            element={appContext.isLoggedIn ? <Matches /> : <Forbidden />}
          />
          <Route path="*" element={<NotFound />} />
          <Route path="/forbidden" element={<Forbidden />} />
        </Routes>
      </Router>
    </AppProvider>
  );
};

export default App;
