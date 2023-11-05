const tags = new Set();


function remove(button){
    button.parentNode.removeChild(button);
}

function search(event){
    event.preventDefault();
    let searchArea = document.getElementById("search_area");
    let keyword = searchArea.value;
    let tagArr = Array.from(tags);
    let json = JSON.stringify({
        keyword: keyword,
        tags: tagArr
    })
    console.log(json);
    fetch("http://localhost:8080/api/v1/study/test", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: json
    }).then(data => console.log(data));

}

function addTag(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        let tagArea = document.getElementById("tag_area");
        let tagSearchArea = document.getElementById("tag_search_area");
        let newButtonText = tagSearchArea.value;
        if (newButtonText && !tags.has(newButtonText)) {
            tags.add(newButtonText);
            let newButton = `
                <button class="tag_button" onclick="remove(this)">
                    <span class="tag_name">${newButtonText}</span>
                    <svg width="6" height="6" class="tag___close-btn" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 12 12">
                        <path fill="#495057" fill-rule="evenodd"
                            d="M.203.203c.27-.27.708-.27.979 0L6 5.02 10.818.203c.27-.27.709-.27.98 0 .27.27.27.708 0 .979L6.978 6l4.818 4.818c.27.27.27.709 0 .98-.27.27-.709.27-.979 0L6 6.978l-4.818 4.818c-.27.27-.709.27-.98 0-.27-.27-.27-.709 0-.979L5.022 6 .203 1.182c-.27-.27-.27-.709 0-.98z"
                            lip-rule="evenodd">
                        </path>
                    </svg>
                </button>`;
          tagArea.innerHTML += newButton;
        }
        tagSearchArea.value = '';
    }
}