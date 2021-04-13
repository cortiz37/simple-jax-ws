$(document).ready(function () {
    $.ajax({
        url: "/ws-app/j2ee/v1/elements"
    }).then(function (data) {
        let content = "<tbody>";

        content += fillTable(data);

        content += "</tbody>";
        $('#elements').append(content);
    });
});

function fillTable(data) {
    let content = '';
    data.forEach(function (element) {
        content += '<tr>';
        content += '<td>' + element.id + '</td>';
        content += '<td>' + element.name + '</td>';
        content += '<td>' + element.description + '</td>';
        content += '<td>' + element.success + '</td>';
        content += '<td>' + element.amount + '</td>';
        content += '<td><button data-id="' + element.id + '" onclick=deleteElement(this)>Del</button></td>';
        content += '</tr>';
    });
    return content;
}

function deleteElement(e) {
    const elementId = $(e).data('id');
    $.ajax({
        url: "/ws-app/j2ee/v1/elements/" + elementId,
        type: 'DELETE'
    }).then(function (data) {
        location.reload();
    });
}