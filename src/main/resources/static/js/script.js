const handleFormSubmit = async (e) => {
  let formData = new FormData(e.target);

  let destination = formData.get("destination");
  let price = formData.get("price");

  let backendURL = "http://127.0.0.1:8000";

  const payload = {
    destination,
    ticketPrice: price,
  };

  const req = await fetch(`${backendURL}/api/train/add-train`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(payload),
  });

  const res = await req.json();
};

document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".train-crud__form");

  form.addEventListener("submit", (e) => {
    handleFormSubmit(e);
  });
});
