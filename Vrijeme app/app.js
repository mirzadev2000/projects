const weatherform = document.querySelector(".weatherForm");
const cityInput = document.querySelector(".cityInput");
const card = document.querySelector(".card");
const apiKey ="00f961a52033ca7f0c2649b9b0040ce0";

weatherform.addEventListener ("submit" ,async event => {

  event.preventDefault();

  const city = cityInput.value;

  if(city){
      try{
        const weatherData = await getWeatherData(city);
        displayWeatherInfo(weatherData)
      }

      catch(error){
        console.error(error);
        displayError(error);
      }
  }

  else{
    displayError("Molimo Unesite Grad");
  }

});

async function getWeatherData(city){

    const APIurl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`
    const response = await fetch(APIurl);

    if(!response.ok){
        throw new Error("Nije moguće pronaći informacije o vremenu na toj lokaciji.Razlog:Lokacija ne postoji")
    }

    return await response.json();

}

function displayWeatherInfo(data){
const{ name: city,
       main:{ temp,humidity},
      weather:[{description, id}]} = data;


      card.textContent = "";
      card.style.display = "flex";

    const cityDisplay = document.createElement("h1");
    const TempDisplay = document.createElement("p");
    const HumidityDisplay = document.createElement("p");
    const DescriptionDisplay = document.createElement("p");
    const WeatherEmoji = document.createElement("p");

    cityDisplay.classList.add("cityDisplay")
    TempDisplay.classList.add("TempDisplay");
    HumidityDisplay.classList.add("HumidityDisplay");
    DescriptionDisplay.classList.add("DescriptionDisplay")
    WeatherEmoji.classList.add("Weather-Emoji")

    cityDisplay.textContent = city;
    TempDisplay.textContent = `${(temp - 273.15).toFixed(0)}°C`;
    HumidityDisplay.textContent = `Vlažnost: ${humidity}%`;
    DescriptionDisplay.textContent = description;
    WeatherEmoji.textContent = getWeatherEmoji(id);

    card.appendChild(cityDisplay);
    card.appendChild(TempDisplay);
    card.appendChild(HumidityDisplay);
    card.appendChild(DescriptionDisplay);
    card.appendChild(WeatherEmoji);
}

function getWeatherEmoji(weatherID){

  switch(true){
    case (weatherID >= 200 && weatherID < 300):
      return "☔";

      case (weatherID >= 300 && weatherID < 400):
      return "☔";

      case (weatherID >= 500 && weatherID < 600):
      return "❄";

      case (weatherID >= 600 && weatherID < 700):
      return "❄";

      case (weatherID >= 700 && weatherID < 800):
      return "❄";

      case (weatherID === 800):
      return "🌅";

      case (weatherID >= 801 && weatherID < 810):
      return "☁";

      default:
        return"❓";

  }
}

function displayError(messeage){
    const errorDisplay = document.createElement("p");
    errorDisplay.textContent = messeage
    errorDisplay.classList.add("errorDisplay");

    card.textContent = "";
    card.style.display = "flex";
    card.appendChild(errorDisplay);
}