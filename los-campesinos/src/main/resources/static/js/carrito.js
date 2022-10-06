const addToCart = (producto) => {
    let items = localStorage.getItem("cart");
    if (items == undefined) {
        items = new Map();
    } else {
        items = new Map(Object.entries(JSON.parse(items)));
    }

    let value = 1;
    
    console.log(items);
    // if (items.get(producto) != undefined) {
    //     value = items.get(producto) + 1;
    //     console.log("Value", value);
    // }
    // items.set(producto, value);
    if (items.get(`${producto}`) == undefined){
        items.set(`${producto}`, 1)
    }else{
        console.log(value)
        value = items.get(`${producto}`) + 1
        console.log(value)
        items.set(`${producto}`, value)
    }
    console.log(value)
    localStorage.setItem("cart", JSON.stringify(Object.fromEntries(items)));
}


const loadCartDetails = () => {
    let items = localStorage.getItem("cart");
    if (items == undefined) {
        return;
    }

    const totalElem = document.getElementById("total");
    let total = 0;
    let detail = document.getElementById("detail");
    detail.innerText = "";
    items = new Map(Object.entries(JSON.parse(items)));
    Array.from(items)
        .forEach(async ([key, value]) => {
            console.log(typeof(key))
            let response = await fetch('/api/producto/' + key);
            let producto = await response.json();

            const totalPrice = producto.precioKilo * value;
            total += totalPrice;

            let item = [
                // `<div id="movie-${key}" class="row item">`,
                // `    <div class="col-4">`,
                // `        <span class="media-heading">${movie.name}</span>`,
                // `    </div>`,
                // `    <div class="col">`,
                // `        <input type="number" min="1" class="form-control text-end" id="item-${key}" value="${value}" onchange="updateTotalItem('${key}')" />`,
                // `    </div>`,
                // `    <div class="col text-end"><strong id="price-${key}">${formatter.format(parseFloat(movie.price))}</strong></div>`,
                // `    <div class="col text-end"><strong id="total-${key}">${formatter.format(parseFloat(totalPrice))}</strong></div>`,
                // `    <div class="col text-center">`,
                // `        <button type="button" class="btn btn-danger" onclick="removeItem('${key}')"><i class="fa-solid fa-trash"></i></button>`,
                // `    </div>`,
                // `    <hr>`,
                // `</div>`
                `<div class="row shoppingCartItem">`,
                `   <div class="producto-${key} row item">`,
                `       <div class="col-6">`,
                `           <div class="shopping-cart-item d-flex align-items-center h-100 border-bottom pb-2 pt-3">`,
                `               <h6 class="shopping-cart-item-title shoppingCartItemTitle text-truncate ml-3 mb-0">${producto.nombre}</h6>`,
                `               <p>  $<span id="price-${key}">${producto.precioKilo}</span></p>` ,
                `           </div>`,
                `       </div>`,
                `       <div class="col-2">`,
                `           <div class="shopping-cart-price d-flex align-items-center h-100 border-bottom pb-2 pt-3">`,
                `               <p class="item-price mb-0 shoppingCartItemPrice" id="total-${key}">${totalPrice}</p>`,
                `           </div>`,
                `       </div>`,
                `       <div class="col-4">`,
                `           <div`,
                `               class="shopping-cart-quantity d-flex justify-content-between align-items-center h-100 border-bottom pb-2 pt-3">`,
                `               <input class="shopping-cart-quantity-input shoppingCartItemQuantity" type="number" min="1" id="item-${key}" value="${value}" onchange="updateTotalItem('${key}')">`,
                `               <button class="btn btn-danger buttonDelete" type="button" onclick="removeItem('${key}')" >X</button>`,
                `           </div>`,
                `       </div>`,
                `   </div>`,
                `</div>`

            ].join('\n');
            detail.innerHTML = detail.innerHTML + item;
            totalElem.innerText = total;
        });
};

const updateTotalItem = (key) => {
    const totalElem = document.getElementById("total");

    let totalItemElem = document.getElementById("total-" + key);
    let itemValue = document.getElementById("item-" + key).value;
    let priceValue = document.getElementById("price-" + key).innerText;
    let total = totalElem.innerText - totalItemElem.innerText;
    console.log(priceValue)
    console.log(itemValue)
    totalItemElem.innerText = parseInt(itemValue)*parseInt(priceValue);
    console.log(totalItemElem)
    console.log(totalItemElem)
    total += parseInt(totalItemElem.innerText);
    // console.log(total)

    totalElem.innerText = total;
};

const parseIntlNumber = (stringNumber, locale) => {
    var thousandSeparator = Intl.NumberFormat(locale).format(11111).replace(/\p{Number}/gu, '');
    var decimalSeparator = Intl.NumberFormat(locale).format(1.1).replace(/\p{Number}/gu, '');

    return parseInt(stringNumber
        .replace(new RegExp('\\' + thousandSeparator, 'g'), '')
        .replace(new RegExp('\\' + decimalSeparator), '.')
    );
};

const removeItem = (key) => {
    let items = localStorage.getItem("cart");
    items = new Map(Object.entries(JSON.parse(items)));
    items.delete(key);

    const totalItemValue = parseInt(document.getElementById("total-" + key).innerText);
    const totalElem = document.getElementById("total");

    totalElem.innerText = parseInt(totalElem.innerText) - totalItemValue;

    console.log(items, JSON.stringify(Object.fromEntries(items)))
    localStorage.setItem("cart", JSON.stringify(Object.fromEntries(items)));
    console.log(JSON.stringify(items))
    location.reload()

    const movieElm = document.getElementById("producto-"+key);
    movieElm.remove();

}